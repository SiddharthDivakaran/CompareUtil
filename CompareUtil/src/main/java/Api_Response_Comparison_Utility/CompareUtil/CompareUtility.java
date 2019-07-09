package Api_Response_Comparison_Utility.CompareUtil;

public class CompareUtility {

	private Compare comp;

	public CompareUtility() {
		comp = new Compare();
	}

	public void compare(String filePath1, String filePath2) {
		comp.compareResponses(filePath1, filePath2);
	}

}
