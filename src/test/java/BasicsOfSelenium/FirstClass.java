package BasicsOfSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstClass {

	public void LaunchBrowser()
	{
		WebDriver obj= new EdgeDriver();
		obj.manage().window().maximize();
		//WebDriver obj1= new ChromeDriver();
		obj.get("https://www.facebook.com/");
		/*obj.navigate().to("https://www.gmail.com/");
		obj.navigate().back();
		obj.navigate().forward();
		obj.navigate().refresh();*/
		obj.findElement(By.cssSelector("input#email")).sendKeys("sathish");
		obj.findElement(By.cssSelector("input#pass")).sendKeys("kumar");
		obj.findElement(By.cssSelector("input[placeholder='Password']"));
		obj.findElement(By.xpath("//input[@type='text']")).sendKeys("wanted");
		//obj.manage().window().minimize();
		//obj.manage().window().setSize(new Dimension(500,600));
		//obj.quit();
	}


	public void locators()
	{
		/*
		 * id -By.id
		 * name -By.name
		 * className - By.className
		 * Linktext - By.LinkText
		 */
		WebDriver obj= new EdgeDriver();
		obj.manage().window().maximize();
		//WebDriver obj1= new ChromeDriver();
		obj.get("https://www.facebook.com/");
		WebElement username= obj.findElement(By.id("email"));
		username.sendKeys("kumar.sathish189@gmail.com");
		WebElement username1= obj.findElement(By.name("email"));
		username1.clear();
		username1.sendKeys("kumar.sathish189@gmail.com");
		username1.clear();
		//or
		obj.findElement(By.name("email")).sendKeys("23742342348");
		// obj.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("sathih");
		//obj.findElement(By.linkText("Forgotten password?")).click();
		obj.findElement(By.partialLinkText(" passw")).click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstClass F = new FirstClass();
		F.LaunchBrowser();
	}

}
