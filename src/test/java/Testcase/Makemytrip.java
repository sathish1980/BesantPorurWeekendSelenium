package Testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BrowserDriver.BrowserLaunch;
import Pages.SearchPage;
import Pages.SearchResultPage;
import Utils.ReadProperty;

public class Makemytrip extends BrowserLaunch{
	int count=0;
	@BeforeSuite
	public void LaunchDriver()
	{
		launchAndMaximize("chrome");
	}
	@BeforeTest
	public void LaunchURL() throws IOException
	{
		String URL =ReadProperty.GetPropertyData().getProperty("url");
		driver.get(URL);
		SearchPage sp = new SearchPage(driver);
		//sp.ClickOnAdd();
	}
	@Test(priority=0,dataProvider="validSearchTestData",dataProviderClass=MakeMyTripDataProvider.class)
	public void validSearch(String from, String to,String date) throws InterruptedException, IOException
	{
		/*
			Select From location dropdown
			Select value from location
			Select To location dropdown
			Select value To location
			Select Date
			Click Search
			Validate the search result
		 */

		SearchPage sp = new SearchPage(driver);
		Thread.sleep(5000);

		sp.ClickOnFrom();
		test.log(LogStatus.INFO, "From dropdown is Selected");
		sp.SelectValueFromList(from);
		test.log(LogStatus.INFO, "From value is "+from);

		sp.ClickOnTo();
		test.log(LogStatus.INFO, "To dropdown is Selected");

		sp.SelectValueFromList(to);
		test.log(LogStatus.INFO, "To value is "+to);

		sp.SelectDateFromCalender(date);
		test.log(LogStatus.INFO, "Date value is "+date);

		sp.ClickOnSearch();
		test.log(LogStatus.INFO, "Search button is clicker");

		SearchResultPage srp = new SearchResultPage(driver);
		String actualError = srp.WaitandGetErrorValidation();
		System.out.println(actualError);
		Assert.assertEquals(actualError, srp.expectedError);
		String screenshot = sp.getScreenshot(driver,"ValidTestcase"+count);
		//Thread.sleep(10000);
		count=count+1;
		test.log(LogStatus.INFO, test.addScreenCapture(screenshot));
		sp.ClickOnBackButton(driver);

	}

	@AfterMethod
	public void ReportUpdate(ITestResult result) throws IOException
	{
		if (result.getStatus() == 1) {
			test.log(LogStatus.PASS, result.getMethod().getMethodName() +" Test Passed");  // new
		} else if (result.getStatus() == 2) {
			SearchPage sp = new SearchPage(driver);
			String screenshotPath =sp.getScreenshot(driver,result.getMethod().getMethodName());
			test.log(LogStatus.INFO, result.getMethod().getMethodName() +" Test Error info",test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() +" Test Error");  // new
		} else if (result.getStatus() == 3) {
			test.log(LogStatus.SKIP, result.getMethod().getMethodName()+" Test Skipped");  // new
		}
	}

	//@Test(priority=1,dataProvider="invalidSearchTestData",dataProviderClass=MakeMyTripDataProvider.class)
	public void SameCityValidation(String from, String to) throws InterruptedException {
		/*
		 * Click back button
		 * click To location
		 * Select same as from location value
		 * validate error message
		 */
		SearchPage sp = new SearchPage(driver);
		//sp.ClickOnBackButton(driver);
		//sp.ClickOnAdd();
		Thread.sleep(5000);
		sp.ClickOnFrom();
		sp.SelectValueFromList(from);
		sp.ClickOnTo();
		sp.SelectValueFromList(to);
		String actualError =sp.GetSameCityError();
		Assert.assertEquals(actualError, sp.expectedsamecityError);
	}


	@AfterSuite
	public void closeBrowser()
	{
		tearDown();
	}
}
