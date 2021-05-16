/*package Utilities;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import PageClasses.LoginPage;

public class validations 
{
	//properties
	public RemoteWebDriver driver;
	public WebDriverWait wait; 
	LoginPage lp=new LoginPage(driver,wait);
	//Constructor method
	public validations(RemoteWebDriver driver,WebDriverWait wait)
	{
		driver=null;
		wait=null;
	}
	//Operational method
	@Test
	public void verifyDropDown()
	{
		//actual values
		List<String>actualValues=lp.selectDropdown();
		Reporter.log("actual value from drop down"+actualValues);
		//ExpectedValues
		List<String>expectedValues=Arrays.asList("---Your Name---"+"Hermoine Granger"+"Harry Potter"+"Ron Weasly"+"Albus Dumbledore"+"Neville Longbottom");
		Reporter.log("actual value from drop down"+expectedValues);
		Assert.assertEquals(actualValues, expectedValues,"Error in dropdown options compare");
	}

}*/
