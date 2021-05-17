package practice;

import org.testng.annotations.Test;

public class Dummy2 
{
	@Test(expectedExceptions={ArithmeticException.class})
	public void method() 
	{
		int x=10/0;
	}
}
