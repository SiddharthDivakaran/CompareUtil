package Api_Response_Comparison_Utility.CompareUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FileRead implements IFileReader {

	private final int batchSize = 10000;
	private IListner listner;
	private FileType fileType = FileType.TEXT_FILE;

	/**
	 * read files given file path for 2 files
	 * 
	 * @param file1
	 * @param file2
	 * @throws IOException
	 */
	public void readData(String filePath1, String filePath2) throws IOException {
		File file1 = new File(filePath1);
		File file2 = new File(filePath2);

		if (file1.exists() == false) {
			System.out.println("File does not exist for given path: " + filePath1);
			System.exit(0);
		}
		if (file2.exists() == false) {
			System.out.println("File does not exist for given path: " + filePath2);
			System.exit(0);
		}

		if (!file1.getName().split("\\.")[1].equals(fileType.getFileType().toString())
				&& !file2.getName().split("\\.")[1].equals(fileType.getFileType().toString())) {
			System.out.println("Only text file is allowed as input type");
			System.exit(0);
		}

		BufferedReader br1 = new BufferedReader(new FileReader(filePath1));
		BufferedReader br2 = new BufferedReader(new FileReader(filePath2));

		String linesInFile1;
		String linesInFile2;

		List<String> lineData = new ArrayList<String>();
		List<List<String>> Data = new ArrayList<List<String>>();

		int lineCounter = 1;

		while ((linesInFile1 = br1.readLine()) != null | (linesInFile2 = br2.readLine()) != null) {
			if ((linesInFile1 != null) | (linesInFile2 != null)) {
				if (lineCounter == batchSize) {
					listner.execute(Data);
					Data.clear();
					lineCounter = 1;
				}

				lineData.add(linesInFile1);
				lineData.add(linesInFile2);
				Data.add(new ArrayList<String>(lineData));
				lineCounter++;
				lineData.clear();

			}
		}
		listner.execute(Data);
		listner.shutdown();

		br1.close();
		br2.close();

	}

	/**
	 * sets listener
	 * 
	 * @param listner
	 */
	public void setListner(IListner listner) {
		this.listner = listner;
	}

}
