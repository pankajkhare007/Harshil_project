package selenium_basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import navigationDashboard.NavigateToList;

public class CommonSeleniumCommands {

	WebDriver driver;
	String browser = "chrome";
	NavigateToList nav;

	public static void main(String[] args) {
		CommonSeleniumCommands bsc = new CommonSeleniumCommands();
		bsc.launchBrowser("https://cams-exim.com/admin");
	}

	public void launchBrowser(String url) {
		nav = new NavigateToList();

		if (browser.equals("chrome")) {
			
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
		
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement ele = driver.findElement(By.id("email"));
		ele.sendKeys("admin@blitznet.com");
		ele = driver.findElement(By.id("password"));
		ele.sendKeys("blitz@admin");
		ele = driver.findElement(By.id("supplierLogInBtn"));
		ele.click();
		nav.selectEnglishLanguage(driver, "EN");
		nav.goToRfqList(driver);
		nav.readTable(driver);

		driver.close();
	}
	

}
