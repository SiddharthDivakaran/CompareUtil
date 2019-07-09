package Api_Response_Comparison_Utility.CompareUtil;

import java.io.IOException;
import java.util.List;

class Compare implements IComparator<String> {

	private ConnectUrl con;
	private FileRead fr;
	private Executor ex;

	Compare() {
		con = new ConnectUrl();
		fr = new FileRead();
		ex = new Executor();
	}
    /**
     * takes input as 2 urls and compare the responses
     */
	public boolean compare(String url1, String url2) {
		String res1;
		try {
			res1 = con.getResponse(url1).toString();
			String res2 = con.getResponse(url2).toString();
			boolean result = res1.equals(res2);
			return result;
		} catch (IOException e) {
			System.out.println("Error in reading url");
			e.printStackTrace();
			return false;
		}
	}
    /**
     * takes input as files path and get data utilizing read data functionality
     */
	public void getData(String filePath1, String filePath2) {
		
		fr.setListner(ex);
		try {
			fr.readData(filePath1, filePath2);
		} catch (IOException e) {
			System.out.println("Unable to read data due to error:\n" + e.getMessage());
			e.printStackTrace();
		}

	}
    /**
     * compare the urls from files 
     * @param filePath1
     * @param filePath2
     */
	public void compareResponses(String filePath1, String filePath2) {
		getData(filePath1, filePath2);
	}
}
