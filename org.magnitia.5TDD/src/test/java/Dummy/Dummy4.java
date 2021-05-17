package Dummy;

import org.testng.annotations.Test;

public class Dummy4 
{
	@Test(invocationCount=5,invocationTimeOut=25000)
	public void method()
	{
		System.out.println("first program");
	}

}
