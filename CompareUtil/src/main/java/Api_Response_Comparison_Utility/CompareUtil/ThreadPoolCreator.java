package Api_Response_Comparison_Utility.CompareUtil;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class ThreadPoolCreator {

	private static int poolSize = 10;
	private static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(poolSize);

	public static void execute(Task task) {
		executor.execute(task);
	}

	public static void shutdown() {
		executor.shutdown();
	}

}
