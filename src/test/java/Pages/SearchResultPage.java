package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ElementUtils.WebDriverElement;

public class SearchResultPage extends WebDriverElement{

	WebDriver driver;
	public String expectedError = "NETWORK PROBLEM";
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public String WaitandGetErrorValidation()
	{
		WaitforelementTobeVisible(driver,By.className("error-title"));
		String actualError = getTextFromElement(driver.findElement(By.className("error-title")));
		return actualError;
	}

	public String WaitandGetErrorsubttitleValidation()
	{
		WaitforelementTobeVisible(driver,By.className("error-subtitle"));

		String actualError = getTextFromElement(driver.findElement(By.className("error-subtitle")));
		return actualError;
	}
}
