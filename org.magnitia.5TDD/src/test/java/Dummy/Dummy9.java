package Dummy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dummy9 
{
	@Test(priority=1,groups= {"smoke test"})
	public void openBrowser()
	{
		System.out.println("launch browser");
		Assert.assertTrue(false);
	}
	@Test(priority=2,dependsOnMethods= {"openBrowser"},groups= {"smoketest"})
	public void login()
	{
		System.out.println("do login");
	}
	@Test(priority=3,dependsOnGroups= {"smoketest"})
	public void sendMail()
	{
		System.out.println("sent mail");
	}

}
