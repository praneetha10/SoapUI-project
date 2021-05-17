package practice;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dummy8
{
	@DataProvider(parallel=true)
	public Object[][] method1(Method m)
	{
		if(m.getName().equalsIgnoreCase("method2"))
		{
			Object[][] x=new Object[][]{
				                          {12,34,45},
				                          {21,43,65},
				                          {24,23,-65}
					                    };
			return(x);
		}
		else if(m.getName().equalsIgnoreCase("method3"))
		{
			Object[][] x=new Object[][]{
											{"abdul","kalam","APJ"},
											{"Dhoni","MS","india"},
											{"kohli","anushka","baby"},
											{"Rahul","Gandhi","india"}
					};
			return(x); 
		}
		else
		{
			return null;
		}
	}
	
	@Test(priority=1,dataProvider="method1")
	public void method2(int x, int y, int z)
	{
		int w=x+y+z;
		System.out.println(w);
	}
	
	@Test(priority=2,dataProvider="method1")
	public void method3(String x, String y, String z)
	{
		String w=x+"-"+y+"-"+z;
		System.out.println(w);
	}
}




