package Dummy;

import org.testng.Reporter;
import org.testng.annotations.Test;

import UtilityClasses.TestUtility;

public class Dummy21 
{
	public TestUtility tu;
	@Test
	public void method1()throws Exception
	{
		tu=new TestUtility();
		tu.OpenBrower("chrome");
		tu.launchsite("https://www.google.com");
		Thread.sleep(5000);
		String fp=tu.captureScreenShort();
		Reporter.log("chrome browser Opened");
		Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
		tu.closeSite();
	}

}
