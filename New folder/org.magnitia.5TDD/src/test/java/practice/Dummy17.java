package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

import utilities.TestUtility;

public class Dummy17 
{
	public TestUtility tu;
	
	@Test
	public void method1() throws Exception
	{
		tu=new TestUtility();
		tu.openBrowser("chrome");
		tu.launchSite("http://www.google.co.in");
		Thread.sleep(5000);
		String fp=tu.captureScreenshot();
		Reporter.log("Chrome browser opened");
		Reporter.log(
				"<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>"); 
		tu.closeSite();
	}
}




