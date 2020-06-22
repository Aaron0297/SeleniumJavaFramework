package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowser {
	WebDriver driver=null;
	String projectPath= System.getProperty("user.dir");
	@Parameters("browsername")
	@BeforeTest
	public void setup(String browsername) {
		System.out.println("Browser name is :" +browsername);
		if (browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\chromedriver\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
	}
	@Test
	public void test() throws InterruptedException {
		driver.get("https://google.com");
		Thread.sleep(4000);
		
	}
	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Test Completed successfully");
	}

}
