package navigationDashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium_basics.Waiters;

public class NavigateToList {
	
	
	public void goToRfqList(WebDriver driver) {
		
		Waiters waiters = new Waiters();
		waiters.waitForElementClickable(driver, By.xpath("//div[@data-bs-original-title='Total number of Unresponded RFQs']"));
		driver.findElement(By.xpath("//div[@data-bs-original-title='Total number of Unresponded RFQs']")).click();
		
		
		
	}
	public void selectEnglishLanguage(WebDriver driver,String lan) {
		
		String xpath =String.format("//a[text()='%s']", lan);
		driver.findElement(By.xpath("//button[@data-bs-toggle='dropdown']")).click();
		
		driver.findElement(By.xpath(xpath)).click();
		
	}
	
	public void readTable(WebDriver driver) {
		
		WebElement tableWebElement = driver.findElement(By.xpath("//table[@id='rfqTable']"));
		List<WebElement> trList=tableWebElement.findElements(By.tagName("tr"));
		for(WebElement eleList : trList) {
			List<WebElement> tdList = eleList.findElements(By.tagName("td"));
			for(WebElement tdWE : tdList) {
				String data = tdWE.getText();
				System.out.println(data);
			}
		}
		
		
	}

}
