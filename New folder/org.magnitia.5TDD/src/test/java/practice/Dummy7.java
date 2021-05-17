package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dummy7
{
	@Test(priority=1,groups={"smoketest"})
	public void openbrowser()
	{
		System.out.println("launch browser");
		Assert.assertTrue(false);
	}
	
	@Test(priority=2, dependsOnMethods={"openbrowser"}, groups={"smoketest"})
	public void login() 
	{
		System.out.println("do login");
	}
	
	@Test(groups={"realtest"},dependsOnGroups={"smoketest"})
	public void sendMail()
	{
		System.out.println("send a mail");
	}
}







