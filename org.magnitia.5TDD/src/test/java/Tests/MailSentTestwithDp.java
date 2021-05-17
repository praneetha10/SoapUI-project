package Tests;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.ComposePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.LogoutPage;
import UtilityClasses.TestUtility;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class MailSentTestwithDp 
{
	//Properties
	public TestUtility tu;
	public RemoteWebDriver driver;
	public WebDriverWait wait;
	public HomePage hp;
	public LoginPage lp;
	public ComposePage cp;
	public LogoutPage lop;
	public ATUTestRecorder recorder;
	public String vp;
	@BeforeClass
	public void setup()throws Exception
	{
		//create objects to utility classes(have common methods)
		tu=new TestUtility();
		//sart video recordng
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt=new Date();
		vp="target\\mailsenttest"+sf.format(dt);
		recorder=new ATUTestRecorder(vp,false);
		recorder.start();
	}
	@DataProvider()
	public Object[][]providerMethod(Method m)
	{
		Object[][] x=new Object[][]
		{
			{"chrome","magnitia251@gmail.com","Magnit251","praneetha.mullapudi@gmail.com","hi","Don't sleep in class","C:\\Users\\prane\\OneDrive\\Pictures\\Saved Pictures\\ladies_maha_shiva.jpg"},
			{"firefox","magnitia251@gmail.com","Magnit251","praneetha.mullapudi@gmail.com","helo","take care","C:\\Users\\prane\\OneDrive\\Pictures\\Saved Pictures\\lavender.jpg"},
			{"edge","magnitia251@gmail.com","Magnit251","praneetha.mullapudi@gmail.com","helo","Happy Sivarathiri","C:\\Users\\prane\\OneDrive\\Pictures\\Saved Pictures\\lavender.jpg"},
			{"opera","magnitia251@gmail.com","Magnit251","praneetha.mullapudi@gmail.com","helo","Flighting","C:\\Users\\prane\\OneDrive\\Pictures\\Saved Pictures\\lavender.jpg"}
	   };
		return(x);
	}
	@Test(priority=1,dataProvider="providerMethod")
	public void mailSentTest(String bn,String u,String p,String t,String s,String b,String fp) throws Exception
	{
		//Mail  compose tesing with multiple data in cross browser environment
		//Open browser by creating driver object
		RemoteWebDriver driver=tu.OpenBrower(bn);
		//define wait object by using driver object
		WebDriverWait wait=tu.defineWait(driver);
		//create objects to page classes by using driver and wait objects
		HomePage hp=new HomePage(driver,wait);
		LoginPage lp=new LoginPage(driver,wait);
		ComposePage cp=new ComposePage(driver,wait);
		LogoutPage lop=new LogoutPage(driver,wait);
		//Launch sit by using url in properties file
		String url=tu.getValuePropertiesFile("url");
		tu.launchsite(url);
		//Do login using valid data
		hp.uidFill(u);
		hp.uidnext();
		Thread.sleep(5000);
		lp.pwdFill(p);
		lp.pwdnext();
		Thread.sleep(5000);
		//Goto Compose Operation
		try
		{
			cp.clickCompose();
			cp.fillTo(t);
			cp.fillSubject(s);
			cp.fillBody(b);
			cp.attachment(fp);
			cp.clickSend();
			Thread.sleep(5000);
			//Composing testing
			String msg=cp.getOutputMessage();
			if(!msg.contains("sorry"))
			{
				Reporter.log("compose test passed and we got"+msg);
				Assert.assertTrue(true);
			}
			else
			{
				Reporter.log("compose test failed and see");
				String sp=tu.captureScreenShort();
				Reporter.log("<a href=\""+sp+"\"><img src=\""+sp+"\"height =\"100\"width=\"100\"/></a>");
				Assert.fail();
				
			}
			//Do logout
			lop.cickProfilePic();
			lop.clickSigout();
			//close site
			tu.closeSite();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage()+"and see:");
			String sp=tu.captureScreenShort();
			Reporter.log("<a href=\""+sp+"\"><img src=\""+sp+"\"height=\"100\"width=\"100\"/></a>");
			//close site
			tu.closeSite();
			Assert.fail();
		}
	}
	@AfterClass
	public void method4() throws ATUTestRecorderException
	{
		recorder.stop();
	}
	
	

}
