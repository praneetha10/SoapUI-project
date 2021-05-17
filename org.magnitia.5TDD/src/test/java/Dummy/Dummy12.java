package Dummy;

import org.testng.annotations.Test;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dummy12 
{
	@DataProvider(name="testdata")
	public Object[][] datamethod(ITestContext context)
	{
		Object[][] data=null;
		for(String g:context.getIncludedGroups())
		{
			if(g.equalsIgnoreCase("ArithmethicOperations"))
			{
				data=new Object[][] {
										{"10","20"},
										{"40","10"},
										{"75","25"}
									};
					return (data);
			}
			else if(g.equalsIgnoreCase("StringManipulations"))
			{
				data=new Object[][] {
										{"abdul","kalam"},
										{"steve","jobs"}
									};
						return (data);
			}
		}
		return (null);
	}
	@Test(groups= {"ArithmethicOperations"},dataProvider="testdata")
	public void numbersAddition(String x,String y)
	{
		int a=Integer.parseInt(x);
		int b=Integer.parseInt(y);
		int c=a+b;
		System.out.println(c);
	}
	@Test(groups= {"ArithmethicOperations"},dataProvider="testdata")
	public void numbersSubstract(String x,String y)
	{
		int a=Integer.parseInt(x);
		int b=Integer.parseInt(y);
		int c=a-b;
		System.out.println(c);
	}
	
	@Test(groups= {"StringManipulations"},dataProvider="testdata")
	public void stringContract(String x,String y)
	{
		String z=x+y;
		System.out.println(z);
	}
}
