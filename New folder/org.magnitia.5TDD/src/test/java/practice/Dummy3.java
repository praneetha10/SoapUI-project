package practice;

import org.testng.annotations.Test;

public class Dummy3 
{
	public int i=1;
	
	@Test(invocationCount=5, invocationTimeOut=25000)
	public void method() throws Exception
	{
	     System.out.println(i);
	     i++;
	     Thread.sleep(4000);
	}
}
