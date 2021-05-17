package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dummy4 
{
	public int x=10;
	@Test(successPercentage=60, invocationCount=5)
	public void method()
	{
	      if(x%2==0)
	      {
	    	  x++;
	      }
	      else
	      {
	    	  x++;
	    	  Assert.fail();
	      }
	}
}
