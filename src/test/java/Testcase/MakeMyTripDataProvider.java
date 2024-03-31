package Testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.ExcelRead;

public class MakeMyTripDataProvider {

	@DataProvider
	public String[][] validSearchTestData() throws IOException
	{
		return ExcelRead.ReadData("ValidData");
	}

	@DataProvider
	public String[][] invalidSearchTestData() throws IOException
	{
		return ExcelRead.ReadData("InvalidData");
	}


}
