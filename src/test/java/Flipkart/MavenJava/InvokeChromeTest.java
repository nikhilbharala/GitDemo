package Flipkart.MavenJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class InvokeChromeTest {
	WebDriver driver;
	ExtentReports extent;
	
	
	
	
	@Test
	public void openChrome() {
		
		//ExtentTest test = extent.createTest("Flipkart");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikhil.c\\eclipse-workspace\\MavenJava\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		System.out.println(driver.getTitle());
	//	test.fail("Result not matchedd");
	//	extent.flush();
		
	}
	
	@AfterTest
	public void quitDriver() {
		driver.close();
	}
	
	
	
}
