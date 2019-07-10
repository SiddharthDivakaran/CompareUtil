package Api_Response_Comparison_Utility.CompareUtil;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FunctionalityTest {
	@BeforeTest
	public void setUp() {
		CompareUtility comp = new CompareUtility();
		String filePath1 = ClassLoader.getSystemResource("Test1.txt").getPath().toString();
		String filePath2 = ClassLoader.getSystemResource("Test2.txt").getPath().toString();
		comp.compare(filePath1, filePath2);
	}

	@Test
	public void testCompreUtilityFunctionality() {
		String path = System.getProperty("user.dir").toString() + "/UtilityOutput/CompareUtiltyOutput.txt";
		TestUtility t = new TestUtility();
		String res;
		try {
			res = t.fileRead(path);
			assertEquals(res,
					"http://dummy.restapiexample.com/api/v1/employees  equals  http://dummy.restapiexample.com/api/v1/employees",
					"Incorrect output");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
