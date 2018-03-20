package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.Constants;
import utility.ExtentManager;
import utility.Keywords;
import xls_reader.Xls_Reader;

public class Zrx_Login {
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	String testName = "ZoomRx";
	@Test
	public void doLogin(){
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting ZoomRx Login test");
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS);
		test.log(LogStatus.INFO, "Executing keywords ZoomRx Login test");
		Keywords app = new Keywords(test);
		app.executekeywords(testName, xls);
		test.log(LogStatus.PASS, "Test Passed");
	}
	
	@AfterTest
	public void quit()
	{
		rep.endTest(test);
		rep.flush();

	}
}

