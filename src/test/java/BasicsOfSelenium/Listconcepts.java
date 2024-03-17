package BasicsOfSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Listconcepts {

	public void listImplementation(String expectedCountry1,String expectedCountry2) throws InterruptedException
	{
		WebDriver obj= new EdgeDriver();
		obj.manage().window().maximize();
		//WebDriver obj1= new ChromeDriver();
		obj.get("https://leafground.com/select.xhtml;");

		obj.findElement(By.xpath("//*[@id='j_idt87:country']//div[starts-with(@class,'ui-selectonemenu-trigger')]")).click();
		List<WebElement> country = obj.findElements(By.xpath("//*[@id='j_idt87:country_items']//li"));

		/*
		 * 2 approaches
		 * 1.for loop
		 * 2.for each loop
		 */

		for(int i=1;i<country.size();i++)
		{
			String actualCountry = obj.findElement(By.xpath("//*[@id='j_idt87:country_items']//li["+i+"]")).getText();
			if(actualCountry.equalsIgnoreCase(expectedCountry1)) {
				obj.findElement(By.xpath("//*[@id='j_idt87:country_items']//li["+i+"]")).click();
				break;
			}
		}

		Thread.sleep(5000);

		// for each
		obj.findElement(By.xpath("//*[@id='j_idt87:country']//div[starts-with(@class,'ui-selectonemenu-trigger')]")).click();
		//obj.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebDriverWait wait = new WebDriverWait(obj,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j_idt87:country_items']//li[last()]")));

		for(WebElement eachElement :country)
		{
			String actualCountry = eachElement.getText();
			if(actualCountry.equalsIgnoreCase(expectedCountry2)) {
				eachElement.click();
				break;

			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Listconcepts l = new Listconcepts();
		l.listImplementation("India","USA");
	}

}
