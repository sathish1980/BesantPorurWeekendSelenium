package BasicsOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public void dropdownImplementation() throws InterruptedException
	{
		WebDriver obj= new EdgeDriver();
		obj.manage().window().maximize();
		//WebDriver obj1= new ChromeDriver();
		obj.get("https://leafground.com/select.xhtml;");

		Select dropdown = new Select(obj.findElement(By.className("ui-selectonemenu")));
		/*
		 * 1.selectByIndex
		 * 2.selectByValue
		 * 3.selectByVisibleText
		 */
		//dropdown.selectByIndex(4);
		//dropdown.selectByValue("2023");
		dropdown.selectByVisibleText("Selenium");
		Thread.sleep(1000);


	}

	public void mutliselect() throws InterruptedException
	{
		WebDriver browser = new EdgeDriver();

		browser.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");

		Select dropdown = new Select(browser.findElement(By.cssSelector("select[id='second']")));
		/*
		 * isMultiple();
		 */
		if(dropdown.isMultiple())
		{
			dropdown.selectByIndex(1);
			Thread.sleep(1000);
			dropdown.selectByValue("bonda");
			Thread.sleep(1000);
			dropdown.selectByVisibleText("Pizza");
			Thread.sleep(1000);
			dropdown.deselectByIndex(0);
			Thread.sleep(1000);
			dropdown.deselectByValue("donut");
			Thread.sleep(1000);
			dropdown.deselectAll();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Dropdown D = new Dropdown();
		D.mutliselect();
	}

}
