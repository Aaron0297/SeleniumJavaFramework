package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;
public class GoogleSearchTest {
	private static WebDriver driver=null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		googleSearch();
	}
	public static void googleSearch() throws InterruptedException {
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
     driver=new ChromeDriver();
     driver.get("https://google.com");
   
     GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step By Step");
     Thread.sleep(3000);
     GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
     driver.close();
     System.out.println("Test Completed");
	}

}
