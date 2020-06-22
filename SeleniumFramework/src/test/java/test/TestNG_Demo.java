package test;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.Propertiesfile;

public class TestNG_Demo {
	WebDriver driver= null;
	public static String browserName=null;
@BeforeTest
	public void setupTest() {
 		String projectPath= System.getProperty("user.dir");
 		Propertiesfile.getProperties();
 		if (browserName.equalsIgnoreCase("chrome")) {
 		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
        driver=new ChromeDriver();
 		}
 		else if (browserName.equalsIgnoreCase("firefox")) {
 			System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\chromedriver\\geckodriver.exe");
 	        driver=new FirefoxDriver();
 		}
	}
	@Test
	public void googleSearch() throws InterruptedException {
		
     driver.get("https://google.com");
     Thread.sleep(3000);
     driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
     Thread.sleep(3000);
     driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
     
	}
	@AfterTest
	public void tearDownTest() {
		
		driver.close();
		//driver.quit();
	     System.out.println("Test Completed");
	     Propertiesfile.setProperties();
	}

}
