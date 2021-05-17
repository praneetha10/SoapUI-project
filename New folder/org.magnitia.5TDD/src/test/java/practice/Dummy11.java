package practice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Dummy11
{
	@Test
	@Parameters({"x","y"})
	public void testmethod(String a, String b)
	{
		System.out.println(a+" "+b);
	}
}
