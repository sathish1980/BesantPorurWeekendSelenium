package TestNgBasics;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SecondTestNG {

	@BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("BeforeSuite");
	}
	@Test
	public void Testcase4()
	{
		System.out.println("TestCase 4");

	}

	@AfterSuite
	public void AfterSuite()
	{
		System.out.println("AfterSuite");
	}

}
