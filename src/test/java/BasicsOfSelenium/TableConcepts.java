package BasicsOfSelenium;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TableConcepts {
	WebDriver obj;
	@Test
	public void tableImplementation() throws InterruptedException, IOException
	{
		String expectedCountry="France";
		obj= new EdgeDriver();
		obj.manage().window().maximize();
		//WebDriver obj1= new ChromeDriver();
		obj.get("https://leafground.com/table.xhtml;");
		List<WebElement> totalPages = obj.findElements(By.xpath("//*[@class='ui-paginator-pages']//a"));
		for(int j=1;j<=totalPages.size();j++)
		{
			obj.findElement(By.xpath("//*[@class='ui-paginator-pages']//a["+j+"]")).click();
			Thread.sleep(2000);
			List<WebElement> allRows =obj.findElements(By.xpath("//div[@id='form:j_idt89']//table//tbody//tr"));
			for(int i=1;i<=allRows.size();i++)
			{
				String actualCountry =obj.findElement(By.xpath("//div[@id='form:j_idt89']//table//tbody//tr["+i+"]//td[2]//span[starts-with(@style,'vertical-align:')]")).getText();
				if(expectedCountry.equalsIgnoreCase(actualCountry))
				{
					String name =obj.findElement(By.xpath("//div[@id='form:j_idt89']//table//tbody//tr["+i+"]//td[1]")).getText();
					System.out.println(name);
					getScreenshot("Testcase"+j+"-"+i);

				}
			}
		}
	}

	public void getScreenshot(String fileName) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)obj;
		File SourceFile =ts.getScreenshotAs(OutputType.FILE);
		File DestinationFile = new File(System.getProperty("user.dir")+"//Screenshot//"+fileName+".png");
		FileUtils.copyFile(SourceFile,DestinationFile);
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		TableConcepts T = new TableConcepts();
		//T.tableImplementation("France");
	}

}
