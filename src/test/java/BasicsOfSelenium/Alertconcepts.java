package BasicsOfSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertconcepts {

	public void alertimplementation() throws InterruptedException
	{
		//WebDriver obj= new EdgeDriver();

		WebDriver obj= new ChromeDriver();
		obj.manage().window().maximize();
		obj.get("https://leafground.com/alert.xhtml;");
		obj.findElement(By.id("j_idt88:j_idt91")).click();
		obj.switchTo().alert().accept();
		System.out.println(obj.findElement(By.id("simple_result")).getText());

		obj.findElement(By.id("j_idt88:j_idt93")).click();
		obj.switchTo().alert().dismiss();
		System.out.println(obj.findElement(By.id("result")).getText());

		obj.findElement(By.id("j_idt88:j_idt104")).click();
		Alert alert = obj.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Besant Porur");
		alert.accept();
		System.out.println(obj.findElement(By.id("confirm_result")).getText());

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Alertconcepts a = new Alertconcepts();
		a.alertimplementation();
	}

}
