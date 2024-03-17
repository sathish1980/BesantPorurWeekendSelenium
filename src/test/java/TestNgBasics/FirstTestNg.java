package TestNgBasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNg {

	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("BeforeTest");
	}
	@BeforeClass
	public void BeforeClass()
	{
		System.out.println("Before class");
	}

	@AfterClass
	public void AfterClass()
	{
		System.out.println("After class");
	}

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	@Test(priority=0)
	public void Testcase2()
	{
		System.out.println("Testcase2");
	}

	@Test(priority=1)
	public void Testcase3()
	{
		System.out.println("Testcase3");
	}


	@Test(priority=2)
	public void Testcase1()
	{
		System.out.println("Testcase1");
	}

	@AfterTest
	public void AfterTest()
	{
		System.out.println("AfterTest");
	}

}
