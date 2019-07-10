package Api_Response_Comparison_Utility.CompareUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CompareUtilityLogger {
	
	private boolean startLogging;
	
	public CompareUtilityLogger() {
		this.startLogging=true;
	}
	
	public void logOutput(String dataToLog)
	{
       String fileName="CompareUtiltyOutput.txt";
       String directoryName="UtilityOutput";
       String directoryPath=System.getProperty("user.dir")+"/";
       
       if(createDirectory(directoryPath, directoryName))
       {
           try
           {
        	FileWriter fw = new FileWriter(directoryPath+directoryName+"/"+fileName,true);
        	fw.write(dataToLog);
        	fw.write("\r\n");
        	fw.close();
           }
           catch(FileNotFoundException e)
           {
        	   System.out.println("Not able to find the file");
           }
           catch(IOException e)
           {
        	   System.out.println("An I/O exception  has occured");
           }
       }
       else
    	   System.out.println("Unable to create directory for output logging");
       
       
	}
	
	public boolean isLoggingOn()
	{
		if(this.startLogging==true)
			return true;
		return false;
	}
	
	public boolean createDirectory(String directoryPath,String directoryName)
	{
		String filePath=directoryPath+directoryName;
		boolean directoryCreated=false;
		File file = new File(filePath);
		if(!file.exists()) {
			if(file.mkdir())
				directoryCreated=true;
		}
		if(file.exists())
			directoryCreated=true;
		return directoryCreated;
	}

}
