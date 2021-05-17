package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dummy6
{
	@Test(priority=1)
	public void openbrowser()
	{
		System.out.println("launch browser");
		Assert.fail();
	}
	
	@Test(priority=2, dependsOnMethods={"openbrowser"})
	public void login() 
	{
		System.out.println("do login");
	}
	
	@Test(priority=3, dependsOnMethods={"login"}, alwaysRun=true)
	public void sendMail()
	{
		System.out.println("send a mail");
	}
}







