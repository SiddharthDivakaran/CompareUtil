package Api_Response_Comparison_Utility.CompareUtil;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UnitTests {
	
	Compare com;
	ConnectUrl con;
	
	@BeforeClass
	public void setUp()
	{
		com=new Compare();
		con = new ConnectUrl();
	}
	
	@Test(enabled=true)
	public void testCompareInvalidUrls()
	{
		String url1="Sample2";
		String url2="Sample1";
		boolean result=com.compare(url1, url2);
		assertEquals(result, false,"Result should be false for invalid urls");
	}
	
	@Test(enabled=true)
	public void testCompareOneEmptyUrl()
	{
		String url1="http://dummy.restapiexample.com/api/v1/employees";
		String url2="";
		boolean result=com.compare(url1, url2);
		assertEquals(result, false,"Result should be false for invalid urls");
	}
	
	@Test(enabled=true)
	public void testUrlChecker()
	{
		String url="h://we.x";
		boolean result=con.isValidUrl(url);
		assertEquals(result, false,"Unable to validate url");
	}
	
	@Test(enabled=true)
	public void testUrlConection()
	{
		String url="ttp://dummy.restapiexample.com/api/v1/employees";
		try {
			String result=con.getResponse(url).toString();
			assertNotEquals(result, "host is unkown for url", "unable to connect to valid url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
