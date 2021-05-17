package Dummy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dummy8 
{
	@Test(priority=1)
	public void openBrowser()
	{
		System.out.println("open Chrome Browser");
		Assert.fail();
	}
	@Test(priority=2,dependsOnMethods={"openBrowser"})
	public void login()
	{
		System.out.println("do login");
	}
	@Test(priority=3,dependsOnMethods= {"login"},alwaysRun=true)
	public void sendMail()
	{
		System.out.println("send a Mail");
	}

	

}
