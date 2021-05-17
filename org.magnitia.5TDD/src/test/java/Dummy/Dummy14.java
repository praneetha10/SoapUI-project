package Dummy;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dummy14 
{
	@DataProvider()
	public Object[][] method1(Method m)
	{
		if(m.getName().equalsIgnoreCase("method2"))
		{
			Object[][] obj=new Object[][] {
											{20,10,30},
											{25,14,12},
											{45,6,52}
										};
						return(obj);
		}
		else if(m.getName().equalsIgnoreCase("method3"))
		{
			Object[][] obj =new Object[][] {
													{"kala","abdul","priesdent"},
													{"vidhi","kalamini","drawing"},
													{"kamal","hasn","actor"}
												};
								return(obj);
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
		String w=x+"="+y+""+z;
		System.out.println(w);
	}
	
}
