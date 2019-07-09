package Api_Response_Comparison_Utility.CompareUtil;

import java.util.ArrayList;
import java.util.List;

public class Executor implements IListner {

	/**
	 * instantiate the task and assign to the thread pool
	 */
	public void execute(List<List<String>> urls) {
		List<List<String>> data = new ArrayList<List<String>>(urls);
		Task task = new Task(data);
		ThreadPoolCreator.execute(task);
	}
    /**
     * shutdowns the pool after task list exhausted 
     */
	public void shutdown() {
		ThreadPoolCreator.shutdown();
	}

}
