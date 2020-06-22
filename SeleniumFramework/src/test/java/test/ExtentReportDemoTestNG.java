package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemoTestNG {
	WebDriver driver=null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	@BeforeSuite
	public void setupTest() {
		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Test
	public void googleSearch() throws InterruptedException, IOException {
		
		
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		Thread.sleep(3000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		driver.get("https://google.com");
		test.log(Status.INFO, "This step shows usage of log(status, details)");

        test.info("This step shows usage of info(details)");
       
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
   
        test.addScreenCaptureFromPath("screenshot.png");
		

	}
	@AfterSuite
	public void tearDownTest() {

		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}

}
