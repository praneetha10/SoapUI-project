package Dummy;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dummy16 
{
	@DataProvider(name="testdata")
	public Object[][] method1(ITestContext context)
	{
		Object[][] data =null;
		for(String g:context.getIncludedGroups())
		{
			if(g.equalsIgnoreCase("ArithmeticOperations"))
			{
				data=new Object[][]{
										{"10","30"},
										{"30","78"}
									};
					return(data);
			}
			else if(g.equalsIgnoreCase("StringManupulations"))
			{
				data=new Object[][]{
										{"abdul","kalam"},
										{"steve","jobs"}
									};
					return(data);
			}
		}
		return(null);
	}
	@Test(groups= {"ArithmeticOperations"},dataProvider="testdata")
	public void numberAddition(String x,String y)
	{
		int a=Integer.parseInt(x);
		int b=Integer.parseInt(y);
		int c=a+b;
		System.out.println(c);
	}
	@Test(groups= {"StringManupulations"},dataProvider="testdata")
	public void stringConcat(String x,String y)
	{
		String z=x+y;
		System.out.println(z);
	}

}
