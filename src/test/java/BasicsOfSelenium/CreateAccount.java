package BasicsOfSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {

	public void creatAccount() throws InterruptedException
	{
		WebDriver obj= new EdgeDriver();
		obj.manage().window().maximize();
		//WebDriver obj1= new ChromeDriver();
		obj.get("https://www.facebook.com/");
		//obj.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebDriverWait wait = new WebDriverWait(obj,Duration.ofSeconds(60));
		obj.findElement(By.xpath("//*[contains(@id,'u_0_0')]")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[name='firstname']")));

		obj.findElement(By.cssSelector("[name='firstname']")).sendKeys("Sathish");

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[name='lastname']")));

		obj.findElement(By.cssSelector("[name='lastname']")).sendKeys("kumar");

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CreateAccount c = new CreateAccount();
		c.creatAccount();
	}

}
