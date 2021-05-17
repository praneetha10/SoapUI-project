package Dummy;

import org.testng.annotations.Test;

public class Dummy3 
{
	@Test(expectedExceptions= {ArithmeticException.class})
	public void method()
	{
		int x =10/0;
	}

}
