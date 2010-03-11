 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package benchmarks.helpers;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class JsonUtil {

    // ----------- Private static members --------

    private static final Log log = LogFactory.getLog(JsonUtil.class);     // Logging object

    private static JsonFactory jf = new JsonFactory();                 // JSON factory

    // ------------ Public static methods ----------------------


    /**
     * Convert JackSon string to Map<String, String>[].
     *
     * @param str - Jackson string
     * @return Map<String, String>[]
     */
    public static List<Map<String, String>> getListFromJsonArray(String str) {
        try {
            if (StringUtils.isNotBlank(str)) {
                ArrayList<Map<String, String>> arrList = (ArrayList<Map<String, String>>) new ObjectMapper()
                        .readValue(jf.createJsonParser(new StringReader(str)),ArrayList.class);
                return arrList;
            } else {
                log.warn("JacksonUtil.getListsFromJsonArray error| ErrMsg: input string is null ");
                return null;
            }
        } catch (Exception e) {
            log.error("JacksonUtil.getListsFromJsonArray error| ErrMsg: " + e.getMessage(), e);
            return null;
        }

    }


    /**
     * Convert JackSon string to Map<String, String>
     *
     * @param str - jackson string
     * @return Map<String, String>
     */
    public static Map<String, String> getMapFromJsonString(String str) {
        try {
            if (StringUtils.isNotBlank(str)) {
                Map<String, String> map = (Map<String, String>) new ObjectMapper()
                        .readValue(jf.createJsonParser(new StringReader(str)),Map.class);
                return map;
            } else {
                log.warn("ErrMsg: input string is null ");
                return null;
            }
        } catch (Exception e) {
            log.error("ErrMsg: " + e.getMessage(), e);
            return null;
        }
    }

        /**
     * Convert JackSon string to Map<String, String>
     *
     * @param str - jackson string
     * @return Map<String, String>
     */
    public static Map<String,Map<String,String>> getMapMapFromJsonString(String str) {
        try {
            if (StringUtils.isNotBlank(str)) {
                Map<String,Map<String,String>> map = (Map<String,Map<String,String>>) new ObjectMapper()
                        .readValue(jf.createJsonParser(new StringReader(str)),Map.class);
                return map;
            } else {
                log.warn("ErrMsg: input string is null ");
                return null;
            }
        } catch (Exception e) {
            log.error("ErrMsg: " + e.getMessage(), e);
            return null;
        }
    }



    /**
     * Convert Map<String, String>[] to JackSon string
     *
     * @param list Array of Map<String,String>
     * @return jackson string
     */
    public static String getJsonStringFromList(List<Map<String, String>> list) {
        try {
            StringWriter sw = new StringWriter();
            JsonGenerator gen = jf.createJsonGenerator(sw);
            new ObjectMapper().writeValue(gen, list);
            gen.flush();
            return sw.toString();
        } catch (Exception e) {
            log.error("JacksonUtil.getJsonStringFromMap error| ErrMsg: " + e.getMessage(), e);
            return null;
        }
    }

    /**
     * Convert Map<String, String> to JackSon string
     *
     * @param aMap Map
     * @return Map<String, String>
     */
    public static String getJsonStringFromMap(Map<String, String> aMap) {
        try {
            StringWriter sw = new StringWriter();
            JsonGenerator gen = jf.createJsonGenerator(sw);
            new ObjectMapper().writeValue(gen, aMap);
            gen.flush();
            return sw.toString();
        } catch (Exception e) {
            log.error("ErrMsg: " + e.getMessage(), e);
            return null;
        }
    }

    /**
     * Convert Map<String, String> to JackSon string
     *
     * @param aMap Map
     * @return Map<String, String>
     */
    public static String getJsonStringFromMapMap(Map<String, Map<String,String>> aMap) {
        try {
            StringWriter sw = new StringWriter();
            JsonGenerator gen = jf.createJsonGenerator(sw);
            new ObjectMapper().writeValue(gen, aMap);
            gen.flush();
            return sw.toString();
        } catch (Exception e) {
            log.error("ErrMsg: " + e.getMessage(), e);
            return null;
        }
    }



    /**
     * Test Stub
     *
     * @param args
     */
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "jason");
        map.put("email", "jason@hotmail.com");

        // Convert map to JSON string
        String jsonString = JsonUtil.getJsonStringFromMap(map);
        System.out.println(jsonString);

        // Convert Json string to map
        Map<String, String> newMap = JsonUtil.getMapFromJsonString(jsonString);
        System.out.println(newMap);


        Map<String, String> anotherMap = new HashMap<String, String>();
        anotherMap.put("name", "alice");
        anotherMap.put("email", "alice@hotmail.com");

        List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
        mapList.add(map);
        mapList.add(anotherMap);
        // Convert to json string
        jsonString = JsonUtil.getJsonStringFromList(mapList);
        System.out.println(jsonString);

        // Convert Json string to list of map
        List<Map<String, String>> newMapList = JsonUtil.getListFromJsonArray(jsonString);
        System.out.println(newMapList);


    }
}
