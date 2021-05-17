package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;

import utilities.TestUtility;

public class LoginTestWithXml
{
	public TestUtility tu;
	public RemoteWebDriver driver;
	public WebDriverWait wait;
	public HomePage hp;
	public LoginPage lp;
	public ComposePage cp;
	public LogoutPage lop;
	
	@BeforeClass
	public void setup() throws Exception
	{
		//Create objects to Utility classes(have common methods)
		tu=new TestUtility();
	}
	
	@Test(priority=1)
	@Parameters({"browser"})
	public void launch(String bn) throws Exception
	{
		driver=tu.openBrowser(bn);
		wait=tu.defineWait(driver);
		hp=new HomePage(driver,wait);
		lp=new LoginPage(driver,wait);
		cp=new ComposePage(driver,wait);
		lop=new LogoutPage(driver,wait);
		//Launch site by using url in properties file
		String url=tu.getValueInPropertiesFile("url");
		tu.launchSite(url);
	}
	
	@Test(priority=2)
	@Parameters({"uid", "uidcriteria"})
	public void uidTest(String u, String uc) throws Exception
	{
		//User-id testing
		try
		{
			//Enter userid and click next
			hp.uidFill(u); //parameterization
			hp.uidNextClick();
			Thread.sleep(5000);
			if(u.length()==0)  //blank uid
			{
				if(hp.isBlankuidError())
				{
					Reporter.log("Uid blank test passed");
					Assert.assertTrue(true);
				}
				else
				{
					Reporter.log("Uid blank test failed and see:");
					String fp=tu.captureScreenshot();
					Reporter.log(
				"<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
					Assert.fail();
				}
			}
			else if(u.length()!=0 && uc.equalsIgnoreCase("invalid")) //invalid uid
			{
				if(hp.isInvaliduidError())
				{
					Reporter.log("Invalid UID test passed");
					Assert.assertTrue(true);
				}
				else
				{
					Reporter.log("Invalid Uid test failed and see:");
					String fp=tu.captureScreenshot();
					Reporter.log(
				"<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
					Assert.fail();
				}
			}
			else  //valid uid
			{
				if(hp.isPasswordDisplayed())
				{
					Reporter.log("Valid UID test passed");
					Assert.assertTrue(true);
				}
				else
				{
					Reporter.log("Valid Uid test failed and see:");
					String fp=tu.captureScreenshot();
					Reporter.log(
				"<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
					Assert.fail();
				}
			}
		}
		catch(Exception ex)
		{
			Reporter.log(ex.getMessage()+"and see:");
			String fp=tu.captureScreenshot();
			Reporter.log(
		       "<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
			Assert.fail();
		}
	}
	
	@Test(priority=3,dependsOnMethods={"uidTest"})
	@Parameters({"pwd", "pwdcriteria"})
	public void pwdTest(String p, String pc) throws Exception
	{
		if(p.equals("N/A") || pc.equals("N/A"))
		{
			Reporter.log("No need for pwd testing");
			Assert.assertTrue(true);
		}
		else
		{
			//Password Testing
			try
			{
				//Fill password and click next
				lp.pwdfill(p); //parameterization
				lp.pwdnextclick();
				Thread.sleep(5000);
				if(p.length()==0) //blank pwd
				{
					if(lp.isBlankpwdError())
					{
						Reporter.log("PWD blank test passed");
						Assert.assertTrue(true);
					}
					else
					{
						Reporter.log("PWD blank test failed and see");
						String fp=tu.captureScreenshot();
						Reporter.log(
			   "<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
						Assert.fail();
					}
				}
				else if(p.length()!=0 && pc.equalsIgnoreCase("invalid")) //invalid pwd
				{
					if(lp.isInvalidpwdError())
					{
						Reporter.log("Invalid PWD test passed");
						Assert.assertTrue(true);
					}
					else
					{
						Reporter.log("Invalid PWD test failed and see:");
						String fp=tu.captureScreenshot();
						Reporter.log(
			   "<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
						Assert.fail();
					}	
				}
				else //valid pwd
				{
					if(cp.isComposeVisible())
					{
						Reporter.log("Valid PWD test passed");
						Assert.assertTrue(true);
						//Do logout
						lop.clickProfilePic();
						lop.clickSignOut();
					}
					else
					{
						Reporter.log("Valid PWD test failed and see:");
						String fp=tu.captureScreenshot();
						Reporter.log(
				"<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
						Assert.fail();
					}
				}
			}
			catch(Exception ex4)
			{
				Reporter.log(ex4.getMessage()+" and see:");
				String fp=tu.captureScreenshot();
				Reporter.log(
			  "<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
				Assert.fail();
			}
		}
	}
	
	@Test(priority=4)
	public void close() 
	{
		tu.closeSite();
	}
}

