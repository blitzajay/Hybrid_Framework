package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenericKeywords {
	public WebDriver driver;
	public Properties prop;
	ExtentTest test;
	
	public GenericKeywords(ExtentTest test) {
		this.test=test;
		prop = new Properties();
		try 
		{
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/resources/project.properties");
		prop.load(fs);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void openBrowser(String browserType)
	{
		test.log(LogStatus.INFO, "Opening browser");
		if (browserType.equals("Mozilla"))
			{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			}
		else if(browserType.equals("Chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			}
		else if(browserType.equals("ie"))
		{
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void navigate(String urlkey)
	{
		System.out.println("Navigating to "+ prop.getProperty(urlkey));
		test.log(LogStatus.INFO, "Navigating to "+ prop.getProperty(urlkey));
		driver.get(prop.getProperty(urlkey));
	}
	public void click(String locatorkey){
		System.out.println("Clicking on "+ prop.getProperty(locatorkey));
		test.log(LogStatus.INFO,"Clicking on "+ prop.getProperty(locatorkey));
		WebElement e = getElement(locatorkey);
		e.click();
		
	}
	public void clickSubmit(String locatorkey){
		//A workaround method to click on the Submit button when a button is wrapped over a div element
		System.out.println("Clicking on "+ prop.getProperty(locatorkey));
		test.log(LogStatus.INFO,"Clicking on "+ prop.getProperty(locatorkey));
		WebElement e = getElement(locatorkey);
		//e.click();
		e.sendKeys(Keys.RETURN);
	}
	public void cleartext(String locatorkey){
		System.out.println("Clearing the values of "+ prop.getProperty(locatorkey));
		test.log(LogStatus.INFO,"Clearing the values of "+ prop.getProperty(locatorkey));
		WebElement e = getElement(locatorkey);
		e.clear();
	}
	
	public void input(String locatorkey, String data){
		System.out.println("Typing in "+ prop.getProperty(locatorkey));
		test.log(LogStatus.INFO,"Typing in "+ prop.getProperty(locatorkey));
		WebElement e = getElement(locatorkey);
		e.sendKeys(data);
		
	}
	
	public void popup(String locatorkey)
	{
		System.out.println("Switching to frame "+ prop.getProperty(locatorkey));
		driver.switchTo().alert().accept();
		
	}
	public void verifyText(String locatorkey, String expectedText)
	{
		
	}
	
	public void closeBrowser()
	{
		System.out.println("Closing browser");
		//driver.quit
	}

/**********************************************************Utility Function**********************************************************/
	public WebElement getElement(String locatorkey){
		WebElement e = null;
		try{
		if (locatorkey.endsWith("id"))
			e = driver.findElement(By.id(prop.getProperty(locatorkey)));
		else if (locatorkey.endsWith("xpath"))
			e = driver.findElement(By.xpath(prop.getProperty(locatorkey)));
		else if(locatorkey.endsWith("name"))
			e = driver.findElement(By.name(prop.getProperty(locatorkey)));
		else if(locatorkey.endsWith("linktext"))
			e = driver.findElement(By.name(prop.getProperty(locatorkey)));
		} catch(Exception ex){
			Assert.fail("Failure in Element Extraction - "+ locatorkey);
			test.log(LogStatus.FAIL, "Failure in Element Extraction - "+ locatorkey);
		}
		return e;
	}

	/********************************************************************************************************************/	
	
}
