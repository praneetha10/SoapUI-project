package Dummy;

import org.testng.annotations.Test;

public class Dummy7
{
	@Test(priority=1)
	public void method1()
	{
		System.out.println("Open browser");
	}
	@Test(priority=2)
	public void method2()
	{
		System.out.println("Launch site");
	}
	@Test(priority=3)
	public void method3()
	{
		System.out.println("login");
	}
	@Test(priority=4)
	public void mehtod4()
	{
		System.out.println("send a mail");
	}

}
