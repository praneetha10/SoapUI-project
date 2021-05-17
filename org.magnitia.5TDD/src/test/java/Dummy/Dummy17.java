package Dummy;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UtilityClasses.ExcelUtility;

public class Dummy17
{
	//Non groups accessing excel data
	@DataProvider(name="exceldata")
	public Object[][] Method1() throws Exception
	{
		ExcelUtility eu=new ExcelUtility("src\\test\\resources\\Book2.xlsx");
		eu.openSheet("Sheet1");
		int nour=eu.getRowsCount();
		System.out.println("row count is"+nour);
		int nouc=eu.getColumnCount();
		System.out.println("column count is"+nouc);
		Object[][] data=new Object[nour-1][nouc];
		//Skip 1st data row(index=0) due to name of columns
		for(int i=1;i<nour;i++)
		{
			for(int j=0;j<nouc;j++)
			{
				data[i-1][j]=eu.getCellValue(i, j);
			}
		}
		eu.saveAndColseExcel();
		return(data);
	}
	@Test(dataProvider="exceldata")
	public void method2(String x,String y,String z)
	{
		String w= x+"-"+y+"-"+z;
		System.out.println(w);
		
	}
	
	
}
