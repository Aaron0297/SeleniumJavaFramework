package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {
	
	private static WebDriver driver=null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter("extentreports.html");
		
		ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        ExtentTest test1 = extent.createTest("Google Search Test", "Test to validate google Search functionality");
        
        String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
        driver=new ChromeDriver();
        test1.log(Status.INFO, "Starting Test Case");
        driver.get("https://google.com");
        test1.pass("Navigated to google.com");
        
        driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
        test1.pass("Entered text in SearchBox");
        Thread.sleep(3000);
        
        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
        test1.pass("Pressed Keyboard enter key");
        
        driver.close();
        driver.quit();
        test1.pass("Closed the browser");
        test1.pass("Test Completed");
        
     // calling flush writes everything to the log file
        extent.flush();

	}

}
