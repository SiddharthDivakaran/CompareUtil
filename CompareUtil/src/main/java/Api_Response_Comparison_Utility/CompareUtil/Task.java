package Api_Response_Comparison_Utility.CompareUtil;

import java.util.List;

public class Task implements Runnable {

	private List<List<String>> urls;

	Task(List<List<String>> urls) {
		this.urls = urls;
	}

	public void run() {
        CompareUtilityLogger compLog = new CompareUtilityLogger();
		Compare comp = new Compare();
		for (List<String> url : urls) {
			String compResult=comp.compare(url.get(0), url.get(1)) ? "" + url.get(0) + "" + "  equals  " + "" + url.get(1) + ""
					: "" + url.get(0) + "" + "  not equals  " + "" + url.get(1) + "";
			System.out.println(compResult);
			compLog.logOutput(compResult);
		}

	}

}
