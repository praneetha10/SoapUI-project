package Dummy;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dummy15 
{
	@DataProvider()
	public Object[][] method1(Method m)
	{
		if(m.getName().equalsIgnoreCase("method2"))
		{
			Object[][] x=new Object[][] {
				 							{10,20,30},
				 							{53,25,45}
										};
					return(x);
		}
		else
		{
			return null;
		}
	}
	@Test(priority=1,dataProvider="method1")
	public void method2(int x,int y,int z)
	{
		int w=x+y+z;
		System.out.println(w);
	}


}
