package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLess {
	public static void main(String[] args) throws InterruptedException {
		test();
	}
	public static void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumFramework\\drivers\\chromedriver\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Automation");
		Thread.sleep(3000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		 driver.close();
		 driver.quit();
		 System.out.println("Completed");
		
	}

}
