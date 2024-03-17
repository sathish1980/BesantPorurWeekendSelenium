package BasicsOfSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames {

	public void frameImplementation() throws InterruptedException
	{
		WebDriver obj= new EdgeDriver();
		obj.manage().window().maximize();
		//WebDriver obj1= new ChromeDriver();
		obj.get("https://leafground.com/frame.xhtml;");
		//obj.findElement(By.xpath("//button[@id='Click' and text()='Click Me' and contains(@style,'ff7295')]")).click();
		List<WebElement> allFrames = obj.findElements(By.tagName("iframe"));
		int totalFrameSize =allFrames.size();
		for(int i=0;i<totalFrameSize;i++)
		{
			// swith over in to frame
			obj.switchTo().frame(i);
			List<WebElement> ElementExist =obj.findElements(By.xpath("//button[@id='Click' and text()='Click Me' and contains(@style,'ff7295')]"));
			int elementExistSize = ElementExist.size();
			if(elementExistSize>0)
			{
				obj.findElement(By.xpath("//button[@id='Click' and text()='Click Me' and contains(@style,'ff7295')]")).click();

			}
			obj.switchTo().defaultContent();
		}
	}

	public void Makemytrip() throws InterruptedException
	{
		WebDriver obj= new EdgeDriver();
		obj.manage().window().maximize();
		//WebDriver obj1= new ChromeDriver();
		obj.get("https://www.makemytrip.com/");
		try {
			WebDriverWait wait = new WebDriverWait(obj,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("webklipper-publisher-widget-container-notification-frame"));

			/*Thread.sleep(3000);
		List<WebElement> frames = obj.findElements(By.tagName("iframe"));
		if(frames.size()>0)
		{
			obj.switchTo().frame("webklipper-publisher-widget-container-notification-frame");*/
			List<WebElement> elementexist = obj.findElements(By.className("close"));
			if(elementexist.size()>0)
			{
				obj.findElement(By.className("close")).click();
			}
			obj.switchTo().defaultContent();
		}catch(Exception e)
		{

		}
		//}
		//obj.switchTo().defaultContent();
		//obj.findElement(By.xpath("//button[@id='Click' and text()='Click Me' and contains(@style,'ff7295')]")).click();

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Frames F = new Frames();
		F.Makemytrip();
	}

}
