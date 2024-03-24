package Testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BrowserDriver.BrowserLaunch;
import Pages.SearchPage;
import Pages.SearchResultPage;
import Utils.ReadProperty;

public class Makemytrip extends BrowserLaunch{

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
		sp.ClickOnAdd();
	}
	@Test(priority=0)
	public void validSearch() throws InterruptedException
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
		sp.ClickOnFrom();
		sp.SelectValueFromList("MAA");
		sp.ClickOnTo();
		sp.SelectValueFromList("PNQ");
		sp.SelectDateFromCalender("27");
		sp.ClickOnSearch();
		SearchResultPage srp = new SearchResultPage(driver);
		String actualError = srp.WaitandGetErrorValidation();
		System.out.println(actualError);
		Assert.assertEquals(actualError, srp.expectedError);
		//Thread.sleep(10000);
		System.out.println("Pass");
	}

	@Test(priority=1)
	public void SameCityValidation() {
		/*
		 * Click back button
		 * click To location
		 * Select same as from location value
		 * validate error message
		 */
		SearchPage sp = new SearchPage(driver);
		sp.ClickOnBackButton(driver);
		sp.ClickOnAdd();
		sp.ClickOnTo();
		sp.SelectValueFromList("MAA");
		String actualError =sp.GetSameCityError();
		Assert.assertEquals(actualError, sp.expectedsamecityError);
	}

	@AfterSuite
	public void closeBrowser()
	{
		tearDown();
	}
}
