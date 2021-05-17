package practice;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Dummy12 
{
	@Test
	@Parameters({"x","y"})
	public void method123(@Optional("abdul") String a, @Optional("kalam") String b)
	{
		System.out.println(a+" "+b);
	}
}
