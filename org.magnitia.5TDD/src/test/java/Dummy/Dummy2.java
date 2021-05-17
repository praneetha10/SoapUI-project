package Dummy;

import org.testng.annotations.Test;

public class Dummy2 
{
	@Test(description="Open browser",timeOut=5000)
	public void method()
	{
		System.out.println("happy code");
	}

}
