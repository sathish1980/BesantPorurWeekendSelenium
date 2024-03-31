package BrowserDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BrowserLaunch {

	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	String ReportPath = System.getProperty("user.dir")+"//Reports//MakemyTripAutomation.html";

	public void launchAndMaximize(String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		else
		{
			driver =null;
		}
		driver.manage().window().maximize();
		report= new ExtentReports(ReportPath,false);
		test = report.startTest("Automation");
	}

	public void tearDown()
	{
		report.flush();
		driver.quit();

	}
}
