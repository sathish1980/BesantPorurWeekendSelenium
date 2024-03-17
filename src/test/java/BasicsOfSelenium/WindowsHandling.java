package BasicsOfSelenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowsHandling {
	public void windowImplementation() throws InterruptedException
	{
		WebDriver obj= new EdgeDriver();
		obj.manage().window().maximize();
		//WebDriver obj1= new ChromeDriver();
		obj.get("https://leafground.com/window.xhtml");
		String parentWindow = obj.getWindowHandle();
		obj.findElement(By.id("j_idt88:new")).click();
		Set<String> allWindows= obj.getWindowHandles();
		for(String eaachWindowName : allWindows)
		{
			if(!eaachWindowName.equalsIgnoreCase(parentWindow))
			{
				obj.switchTo().window(eaachWindowName);
				List<WebElement> elementExist =obj.findElements(By.id("menuform:j_idt39"));
				if(elementExist.size()>0)
				{
					obj.findElement(By.id("menuform:j_idt39")).click();
					obj.findElement(By.id("menuform:m_overlay")).click();
					obj.findElement(By.id("j_idt88:j_idt91")).click();
					obj.switchTo().alert().accept();
					obj.close();
					obj.switchTo().window(parentWindow);
				}
			}

		}
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WindowsHandling W = new WindowsHandling();
		W.windowImplementation();
	}

}
