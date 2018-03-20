package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Zoomrx_Login {
	WebDriver driver = new FirefoxDriver();

	@Test(priority=1)
	public void doLogin(){
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://zeus-aws.zoomrx.com/z-plus/users/login/loginPage");
		driver.findElement(By.id("UserEmail")).sendKeys("ta1@zrx.com");
		driver.findElement(By.id("UserPassword")).sendKeys("test");
		driver.findElement(By.id("login_button")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Master survey')]")).click();
	}
	//First question
	@Test(priority=2,dependsOnMethods={"doLogin"})
	public void question1(){
		//WebElement element = driver.findElement(By.xpath("//div[text()='No']/preceding-sibling::div"));
		//element.getSize();
		driver.findElement(By.xpath("//div[text()='No']/preceding-sibling::div")).click();
		
	}
	//Second Question
	@Test(priority=3)
	public void Question2(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xpath=//div[text()='Yes']/preceding-sibling::div"))).click();;
		driver.findElement(By.xpath("xpath=//div[text()='No']/preceding-sibling::div")).click();
	}
		
		//Third question
	@Test(priority=4)
	public void Question3(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[text()='List Radio']/preceding-sibling::div/div")).click();
		driver.findElement(By.xpath("//div[text()='Gender']/preceding-sibling::div/div")).click();
		driver.findElement(By.xpath("//div[text()='SCROLL TO SEE MORE']")).click();
		driver.findElement(By.xpath("//button[text()='NEXT QUESTION']")).click();
	}

		
		//Fourth Question
	@Test(priority=5)
	public void Question4(){
		driver.findElement(By.xpath("//div[text()='Choose Attributes']/following-sibling::div/descendant::div[text()='Yes']/preceding-sibling::div")).click();
	}
		
		//Fifth Question
	@Test(priority=6)
	public void Question5(){
		driver.findElement(By.xpath("//div[text()='Medical Assistant']")).click();
	}
	
		//Sixth Question
	@Test(priority=7)
	public void Question6(){
		driver.findElement(By.xpath("//div[text()='Male']/preceding-sibling::div")).click();
	}
		//Seventh Question
	@Test(priority=8)
	public void Question7(){
		driver.findElement(By.xpath("//div[text()='NEXT']")).click();
	}
		//Submit survey
	@Test(priority=9)
	public void Question8(){
		driver.findElement(By.xpath("//button[text()='Submit Survey']")).click();
		
		
	}
	
}
