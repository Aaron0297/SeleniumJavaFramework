import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {
	public static void main(String[] args)  {
		//WebDriver driver= new FirefoxDriver();
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://google.com");
		WebElement textbox= driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		textbox.sendKeys("Automation Step by Step");
		try {
		Thread.sleep(3000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
		
	}

}
