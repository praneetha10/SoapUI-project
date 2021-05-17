package GlueCode;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pageclasses.ComposePage;
import Pageclasses.HomePage;
import Pageclasses.LoginPage;
import Pageclasses.LogoutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdef1 
{
	public WebDriverWait wait;
	public HomePage hp;
	public ComposePage cp;
	public LoginPage lp;
	public LogoutPage lop;
	public Shared sh;
	
	//Constructor method
	public Stepdef1(Shared sh)
	{
		this.sh=sh;
	}
	
	@Then ("title should be \"(.*)\"$")
	public void title_should_be(String expected) throws Exception
	{
		String actual=sh.driver.getTitle();
		if(expected.equals(actual))
		 {
			   sh.s.log("Gmail title test passed");
			   Assert.assertTrue(true);
		 }
		 else
		 {
			 byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			 sh.s.attach(b, "image/png", "Gmail title test field");
			 Assert.assertTrue(false);
		 }
	}
		
	@When ("quit site")
	@When("close site")
	public void method4() 
	{
	    sh.tu.closeSite();
	}
	@When("^enter userid as(.*)$")
	public void method1(String uid) 
	{
		hp.uidFill(uid);
	  
	}
	

	@When("click userid next button")
	public void click_userid_next_button() {
	    hp.isuseridNext();
	}
	@And ("userid validation via pwd")
	public void method9()
	{
		try
		{
			hp.isPasswordDisplayed();
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
	}

	@Then ("^validate outcome related to given userid criteria like(.*)$")
	public void method2(String e)
	{
		try
		{
						
			if(e.equals("blank")&& hp.isBlankuiderror())
			{
				sh.s.log("Blank uid test was passed");
			}
			else if(e.equals("invalid")&& hp.isInvaliduiderror())
			{
				sh.s.log("Invalid uid test was passed");
			}
			
			else
			{
				byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
				sh.s.attach(b, "png","Gmail Uid test failed");
				Assert.assertTrue(false);
			}
		}
		catch(Exception ex)
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(b, "png", ex.getMessage());
			Assert.assertTrue(false);
		}
	}
	@Given("^launch site using \"(.*)\"$")
	public void launch_site_using_chrome(String bn) throws Exception 
	{
	    sh.driver=sh.tu.openBrowser(bn);
	    wait=sh.tu.defineWait(sh.driver);
	    hp=new HomePage(sh.driver,wait);
	    lp=new LoginPage(sh.driver,wait);
	    cp=new ComposePage(sh.driver,wait);
	    lop=new LogoutPage(sh.driver,wait);
	    //Launch site by using url in properties file
	    String url=sh.tu.getValuesInProperties("url");
	    sh.tu.launchsite(url);
	  }

	@When("enter password as(.*)$")
	public void enter_password_as_magnit251(String p) {
	   lp.isPassword(p);
	}

	@When("click password next button")
	public void click_password_next_button() {
	   lp.isNextpwd();
	}
	@And ("pwd validation via cmp")
	public void method6()
	{
		cp.isComposeVisiable();
	}

	@Then("^Validate outcome related to given password criteria like(.*)$")
	public void method4(String c)
	{
	    try
	    {
	    	if(c.equals("blank")&&lp.isBlankpwd())
	    	{
	    		sh.s.log("Blank pwd test was passed");
	    	}
	    	else if(c.equals("invalid")&&lp.ispwdError())
	    	{
	    		sh.s.log("invalid pwd test was passed");
	    	}
	    	else
	    	{
	    		byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
	    		sh.s.attach(b, "image/png", "Gmail pwd test failed");
	    		Assert.assertTrue(false);
	    	}
	    }
	    catch(Exception ex)
	    {
	    	byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
	    	sh.s.attach(b, "image/png",ex.getMessage());
	    	Assert.assertTrue(false);
	    }
	}
	@And ("Send mail and test")
	public void method6(DataTable dt) throws Exception
	{
		List<List<String>>l=dt.asLists();
		for(int i=1;i<l.size();i++)
		{
			cp.isCompose();
			Thread.sleep(5000);
			cp.fillTo(l.get(i).get(0));
			cp.fillSubject(l.get(i).get(1));
			Thread.sleep(5000);
			cp.fillBody(l.get(i).get(2));
			Thread.sleep(5000);
			cp.attachFile(l.get(i).get(3));
			Thread.sleep(5000);
			cp.sendMsg();
			//Compose testing
			String msg=cp.getOutputmsg();
			if(!msg.contains("sorry"))
			{
				sh.s.log("compose test passed and we got"+msg);
				Assert.assertTrue(true);
			}
			else
			{
				byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
				sh.s.attach(b, "image/png", "mail compose test failed");
				Assert.assertTrue(false);
			}
		}
	}
	@When ("do logout")
	public void method7()
	{
		lop.cickProfilePic();
		lop.clickSignout();
	}
}
