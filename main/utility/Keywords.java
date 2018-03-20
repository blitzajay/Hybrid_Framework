	package utility;

import com.relevantcodes.extentreports.ExtentTest;

import xls_reader.Xls_Reader;


public class Keywords {
	ExtentTest test;
	GenericKeywords app;
	
	public Keywords(ExtentTest test) {
		this.test=test;
	}

	public void executekeywords (String testUnderExecution, Xls_Reader xls){
		/*GenericKeywords app = new GenericKeywords();
		app.openBrowser("Chrome");
		app.navigate("url");
		app.input("email_id", "ta1@zrx.com");
		app.input("password_id", "test");
		app.click("loginButton_id");
		app.click("mastersurvey_xpath");
	*/
		//String testUnderExecution="ZoomRx";
		 app = new GenericKeywords(test);
		//Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS);
		//Xls_Reader xls = new Xls_Reader(System.getProperty("/Users/blitzajay/Documents/workspace/ZoomRx_Hybrid_Framework/data/SuiteA.xlsx");
		//Xls_Reader datatable = new Xls_Reader("/Users/blitzajay/Desktop/Ajay.xlsx");

		int rows = xls.getRowCount(Constants.KEYWORDS_SHEET);
		for (int rNum = 2; rNum<=rows; rNum++){
			String tcid = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.TCID_COL, rNum);
			if (tcid.equals(testUnderExecution)){
			String keyword = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.KEYWORD_COL, rNum);
			String object = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.OBJECT_COL, rNum);
			String data = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.DATA_COL, rNum);
			
			System.out.println(tcid+"----"+keyword+"----"+object+"----"+data);
			
			if (keyword.equals("openBrowser"))
				app.openBrowser(data);
			else if (keyword.equals("navigate"))
				app.navigate(object);
			else if (keyword.equals("click"))
				app.click(object);
			else if (keyword.equals("input"))
				app.input(object, data);
			else if (keyword.equals("closeBrowser"))
				app.closeBrowser();	
			else if (keyword.equals("cleartext"))
				app.cleartext(object);
			else if (keyword.equals("clickSubmit"))
				app.clickSubmit(object);
			else if (keyword.equals("popup"))
				app.popup(object);
			}
			}
		}
		public GenericKeywords getGenerickeywords(){
			return app;
	}
	
}
