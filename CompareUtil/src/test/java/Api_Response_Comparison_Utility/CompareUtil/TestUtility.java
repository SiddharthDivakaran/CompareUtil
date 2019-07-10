package Api_Response_Comparison_Utility.CompareUtil;

import java.io.BufferedReader;
import java.io.FileReader;

public class TestUtility {
	
	public String fileRead(String filePath) throws Exception
	{
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String linesInFile;
			
			while ((linesInFile = br.readLine()) != null) {
				if (linesInFile != null)
					return linesInFile;
			}
		return "unable to read";
	}

}
