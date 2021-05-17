package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelUtility;

public class Dummy10
{
	@DataProvider(name="exceldata")
	public Object[][] method1() throws Exception
	{
		ExcelUtility eu=new ExcelUtility("src\\test\\resources\\dummy10.xlsx");
		eu.openSheet("Sheet1");
		int nour=eu.getRowsCount();
		int nouc=eu.getColumnscount();
		Object[][] data=new Object[nour-1][nouc];
		//skip 1st row(index=0) due to names of columns
		for(int i=1;i<nour;i++)
		{
			for(int j=0;j<nouc;j++)
			{
				data[i-1][j]=eu.getCellValue(i,j);
			}
		}
		eu.saveAndCloseExcel();
		return(data);
	}
	
	@Test(dataProvider="exceldata")
	public void method2(String x, String y, String z)
	{
		String w=x+"-"+y+"-"+z;
		System.out.println(w);
	}
}
