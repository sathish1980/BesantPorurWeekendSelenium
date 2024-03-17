package BasicsOfSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseActions {


	public void mouseimplementation() throws InterruptedException
	{
		WebDriver obj= new EdgeDriver();
		obj.manage().window().maximize();
		//WebDriver obj1= new ChromeDriver();
		obj.get("https://www.ebay.com/");
		Actions a = new Actions(obj);
		a.moveToElement(obj.findElement(By.xpath("//li[@class='vl-flyout-nav__js-tab']//*[text()='Electronics']"))).perform();
		//Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(obj,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Computers and tablets']")));

		a.moveToElement(obj.findElement(By.xpath("//*[text()='Compusters and tablets']"))).click().perform();
	}

	public void mouseimplementation2() throws InterruptedException
	{
		//WebDriver obj= new EdgeDriver();

		WebDriver obj= new ChromeDriver();
		obj.manage().window().maximize();
		obj.get("https://www.facebook.com/");
		Actions a = new Actions(obj);
		a.moveToElement(obj.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
	}


	public void dragandDrop() throws InterruptedException
	{
		//WebDriver obj= new EdgeDriver();

		WebDriver obj= new ChromeDriver();
		obj.manage().window().maximize();
		obj.get("https://leafground.com/drag.xhtml");
		Actions a = new Actions(obj);
		a.moveToElement(obj.findElement(By.id("form:drag_content"))).dragAndDrop(obj.findElement(By.id("form:drag_content")), obj.findElement(By.id("form:drop_content"))).perform();
	}

	public void dragandDropby() throws InterruptedException
	{
		//WebDriver obj= new EdgeDriver();

		WebDriver obj= new ChromeDriver();
		obj.manage().window().maximize();
		obj.get("https://leafground.com/drag.xhtml");
		Actions a = new Actions(obj);
		a.moveToElement(obj.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[2]"))).dragAndDropBy(obj.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[2]")),-50,0).perform();
		a.moveToElement(obj.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[2]"))).dragAndDropBy(obj.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[2]")),30,0).perform();
		a.moveToElement(obj.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[1]"))).dragAndDropBy(obj.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[1]")),-50,0).perform();
		a.moveToElement(obj.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[1]"))).dragAndDropBy(obj.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[1]")),30,0).perform();

	}

	public void WAITFORELEMENT() throws InterruptedException
	{
		//WebDriver obj= new EdgeDriver();

		WebDriver obj= new ChromeDriver();
		obj.manage().window().maximize();
		obj.get("https://leafground.com/drag.xhtml");
		obj.findElement(By.cssSelector("[id='form:j_idt119']")).click();
		WebDriverWait wait = new WebDriverWait(obj,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-progressbar-label"),"100%"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ui-growl-title")));

		String toastText = obj.findElement(By.className("ui-growl-title")).getText();
		System.out.println(toastText);
	}

	public void keyboardActions() {
		WebDriver obj= new ChromeDriver();
		obj.manage().window().maximize();
		obj.get("https://www.facebook.com/");
		obj.findElement(By.id("email")).sendKeys("sathish");
		Actions a = new Actions(obj);
		a.moveToElement(obj.findElement(By.id("email"))).keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.SHIFT).keyDown(Keys.TAB).keyUp(Keys.TAB).keyUp(Keys.SHIFT).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();

	}

	public void keyboardActionswithRobot() throws AWTException {
		WebDriver obj= new ChromeDriver();
		obj.manage().window().maximize();
		obj.get("https://www.facebook.com/");
		Actions a = new Actions(obj);
		a.moveToElement(obj.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);


	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		MouseActions m = new MouseActions();
		m.keyboardActionswithRobot();
	}

}
