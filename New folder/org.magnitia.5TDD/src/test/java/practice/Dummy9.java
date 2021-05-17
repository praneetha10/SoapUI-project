package practice;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dummy9
{
	@DataProvider(name="testdata")
	public Object[][] datamethod(ITestContext context)
	{
		Object[][] data=null;
		for(String g:context.getIncludedGroups())
		{
			if(g.equalsIgnoreCase("ArithmeticOperations"))
			{
				data=new Object[][]
						{
					       {"10","20"},
					       {"30","78"}	
				        };
				return(data);
			}
			else if(g.equalsIgnoreCase("StringsManipulations"))
			{
				data=new Object[][]
						{
					      {"abdul","kalam"},
					      {"steve","jobs"}	
				        };
				return(data);
			}
		}
		return(null);
	}
	
	@Test(groups={"ArithmeticOperations"},dataProvider="testdata")
	public void numbersaddition(String x, String y)
	{
		int a=Integer.parseInt(x);
		int b=Integer.parseInt(y);
		int c=a+b;
		System.out.println(c);
	}
	
	@Test(groups={"ArithmeticOperations"},dataProvider="testdata")
	public void numberssubstract(String x, String y)
	{
		int a=Integer.parseInt(x);
		int b=Integer.parseInt(y);
		int c=a-b;
		System.out.println(c);
	}
	
	@Test(groups={"StringsManipulations"},dataProvider="testdata")
	public void stringsconcat(String x, String y)
	{
		String z=x+y;
		System.out.println(z);
	}
}
