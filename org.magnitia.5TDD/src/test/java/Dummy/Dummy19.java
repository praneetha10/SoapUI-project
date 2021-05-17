package Dummy;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Dummy19
{
	@Test
	@Parameters({"x","y"})
	public void method1(@Optional("abdul")String a,@Optional("kalam")String b)
	{
		System.out.println(a+" "+b);
	}

}
