package BasicsOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class VV {

	//verification

	public void VVimplemenation()
	{
		WebDriver obj= new EdgeDriver();
		obj.manage().window().maximize();
		//WebDriver obj1= new ChromeDriver();
		obj.get("https://leafground.com/select.xhtml;");

		/*
		 * 1.getTitle
		 * 2.getCurrentUrl
		 * 3.getPageSource
		 */

		System.out.println(obj.getTitle());
		System.out.println(obj.getCurrentUrl());
		System.out.println(obj.getPageSource());
		System.out.println(obj.findElement(By.tagName("h5")).getText());
		System.out.println(obj.findElement(By.className("ui-selectonemenu")).getAttribute("style"));
		System.out.println(obj.getWindowHandle());
		System.out.println(obj.getWindowHandles());
		System.out.println(obj.findElement(By.className("ui-selectonemenu")).getCssValue("vertical-align"));

		/*
		 * validation commands
		 * 1.isSelected
		 * 2.isDisplayed
		 * 3.isEnabled
		 */

		obj.findElement(By.className("ui-selectonemenu")).isDisplayed();

		obj.findElement(By.className("ui-selectonemenu")).isEnabled();

		obj.findElement(By.className("ui-selectonemenu")).isSelected();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VV v = new VV();
		v.VVimplemenation();
	}

}
