package pt.unl.citi.tpcw.transactions;

import org.deuce.transaction.Transaction;
import org.deuce.transform.ExcludeTM;

import pt.unl.citi.tpcw.Executor;

@ExcludeTM
public class AdminChangeTransaction extends Transaction<Void> {
	final Executor e;
	final int id;

	public AdminChangeTransaction(final Executor e, final int id) {
		this.e = e;
		this.id = id;
	}

	@Override
	public Void execute() {
		long init_time = System.nanoTime();
		e.AdminChange(id);
		long end_time = System.nanoTime();
		e.client_result_handler.logResult("OP_ADMIN_CHANGE",
				((end_time / 1000 / 1000) - (init_time / 1000 / 1000)));
		e.counter.increment();
		Executor.operations.incrementAndGet();
		return null;
	}

}