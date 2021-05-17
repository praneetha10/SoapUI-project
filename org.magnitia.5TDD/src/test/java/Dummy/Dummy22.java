package Dummy;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerBodies.class)
public class Dummy22
{
	@Test(priority=1)
	public void method1()
	{
		Assert.assertTrue(true);
	}
	@Test(priority=2)
	public void method2()
	{
		Assert.assertTrue(false);
	}
	@Test(dependsOnMethods= {"method2"},priority=3) // assertTrue(false) method skipped
	public void method3()
	{
		System.out.println("hi");
	}
	

}
