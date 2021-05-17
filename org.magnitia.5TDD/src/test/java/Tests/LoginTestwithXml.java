package Tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.ComposePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.LogoutPage;
import UtilityClasses.TestUtility;

public class LoginTestwithXml 
{
	public TestUtility tu;
	public RemoteWebDriver driver;
	public WebDriverWait wait;
	public HomePage hp;
	public LoginPage lp;
	public ComposePage cp;
	public LogoutPage lop;
	@BeforeClass
	public void Setup()throws Exception
	{
		//create objects to utility classes 
		tu=new TestUtility();
	}
	@Test(priority=1)
	@Parameters({"browser"})
	public void launch(String bn) throws Exception
	{
		driver=tu.OpenBrower(bn);
		wait=tu.defineWait(driver);
		hp=new HomePage(driver,wait);
		lp=new LoginPage(driver,wait);
		cp=new ComposePage(driver,wait);
		lop=new LogoutPage(driver,wait);
		//Launch site by using url in properties file
		String url=tu.getValuePropertiesFile("url");
		tu.launchsite(url);
	}
	@Test(priority=2)
	@Parameters({"uid","uidcriteria"})
	public void uidTest(String u,String uc) throws Exception
	{
		//uid Testing
		try
		{
			//Enter userid and click test
			hp.uidFill(u);
			hp.uidnext();
			Thread.sleep(5000);
			if(u.length()==0)
			{
				if(hp.isBlankuidError())
				{
					Reporter.log("uid blank test passed");
					Assert.assertTrue(true);
				}
				else
				{
					Reporter.log("uid blank test failed and sec");
					String fp=tu.captureScreenShort();
					Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\"height=\"100\"width=\"100\"/></a>");
					Assert.fail();
				}
			}
			else if(u.length()!=0 && uc.equalsIgnoreCase("invaild"))
			{
				if(hp.isInvaliduidError())
				{
					Reporter.log("Invaild UiD test passed");
					Assert.assertTrue(true);
				}
				else
				{
					Reporter.log("Invaild uid test failed and see:");
					String fp=tu.captureScreenShort();
					Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\"height=\"100\" width=\"100\"/></a>");
					Assert.fail();
				}
			}
			else
			{
				if(hp.isPasswordDisplayed())
				{
					Reporter.log("vaild Uid test passed");
					Assert.assertTrue(true);
				}
				else
				{
					Reporter.log("valid uid test failed and see");
					String fp=tu.captureScreenShort();
					Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\"height=\"100\"width=\"100\"/></a>");
					Assert.fail();
				}
			}
		}
		catch(Exception ex)
		{
			Reporter.log(ex.getMessage()+"and see:");
			String fp=tu.captureScreenShort();
			Reporter.log ("<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\"width=\"100\"/></a>");
			Assert.fail();
		}
	}
	@Test(priority=3,dependsOnMethods= {"uidTest"})
	@Parameters({"pwd","pwdcriteria"})
	public void pwdTest(String p,String pc) throws Exception
	{
		if(p.equals("N/A")||pc.equals("N/A"))
		{
			Reporter.log("No need for pwd testing");
			Assert.assertTrue(true);
		}
		else
		{
			//Password Testing
			try
			{
				//Fill Password and click next
				lp.pwdFill(p);
				lp.pwdnext();
				Thread.sleep(5000);
				if(p.length()==0)
				{
					if(lp.isBlankpwderror())
					{
						Reporter.log("pwd blanktest passed");
						Assert.assertTrue(true);
					}
					else
					{
						Reporter.log("pwd blank test failed and see:");
						String fp=tu.captureScreenShort();
						Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"1000\"/></a>");
						Assert.fail();
					}
				}
				else if(p.length()!=0&&pc.equalsIgnoreCase("invaild"))
				{
					if(lp.isInvalidpwdError())
					{
						Reporter.log("Invaild pwd test passed");
						Assert.assertTrue(true);
					}
					else
					{
						Reporter.log("Invalid pwd test failed and see:");
						String fp=tu.captureScreenShort();
						Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\"height=\"100\"widht=\"100\"/></a>");
						Assert.fail();
					}
				}
				else
				{
					if(cp.isComposevisiable())
					{
						Reporter.log("vaild pwd test passed");
						Assert.assertTrue(true);
						lop.cickProfilePic();
						lop.clickSigout();
					}
					else
					{
						Reporter.log("vaild pwdtest failed and see:");
						String fp=tu.captureScreenShort();
						Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\"height=\"100\"width=\"100\"/></a>");
						Assert.fail();
					}
				}
				
				
			}
			catch(Exception ex)
			{
				Reporter.log(ex.getMessage()+"and see:");
				String fp=tu.captureScreenShort();
				Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\"height=\"100\"width=\"100\"/></a>");
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
