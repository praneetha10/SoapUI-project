package Dummy;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dummy10 
{
	@DataProvider()
	public Object[][] method1(Method m)
	{
		if(m.getName().equalsIgnoreCase("method2"))
		{
			Object[][] x =new Object[][] {
											
											{12,67,50},
											{5,67,90},
											{45,67,34}
										};
		   return(x);
		}
		else if(m.getName().equalsIgnoreCase("method3"))
		{
			Object[][] x=new Object[][] {
								{"Ram","anji","anjana"},
								{"praneetha","josna","sujith"},
								{"ravi","silica","qura"}
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
	@Test(priority=2,dataProvider="method1")
	public void method3(String x,String y,String z)
	{
		String v=x+y+z;
		System.out.println(v);
	}
}
