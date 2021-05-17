package Utilityclasses;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.checker.units.qual.Length;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageClass.HomePage;
import PageClass.LoginPage;

public class excelutility 
{
	RemoteWebDriver driver;
	WebDriverWait wait;
	LoginPage lp=new LoginPage(driver,wait);
	//Properties 
	private File f;
	private FileInputStream fi;
	private Workbook wb;
	private Sheet sh;
	private FileOutputStream fo;
	//Constructor method
	public excelutility(String fpath) throws Exception
	{
		f=new File(fpath);
		fi=new FileInputStream(f);
		wb=WorkbookFactory.create(fi);
		fo=new FileOutputStream(f);
	}
	
	//Opertional method
	public void openSheet(String sheetname)
	{
		sh=wb.getSheet(sheetname);
	}
	public int getRowsCount()
	{
		int nour=sh.getPhysicalNumberOfRows();
		return(nour);
	}
	public int getColumnsCount()
	{
		int nouc=sh.getRow(0).getLastCellNum();
		return(nouc);
	}
	public void createResultColumn(int colindex)
	{
		SimpleDateFormat sf=new SimpleDateFormat();
		Date dt= new Date();
		Cell rc=sh.getRow(0).createCell(colindex);
		rc.setCellValue(sf.format(dt));
	}
	public String getCellValue(int rowindex,int colindex)
	{
		DataFormatter df=new DataFormatter();
		String value=df.formatCellValue(sh.getRow(rowindex).getCell(colindex));
		return value;
	}
	public void setCellValue(int rowindex,int colindex,String result)
	{
		Cell c=sh.getRow(rowindex).createCell(colindex);
		c.setCellValue(result);
		sh.autoSizeColumn(colindex);
	}
	public void validateDropdown() throws Exception
	{
		List<String>actual1=lp.dropDown();
		List<String>Expected=Arrays.asList("Please Select Class","I","II","III","V","VI","VII","VIII","IX","X");
		if(actual1==Expected)
		{
			DataFormatter df=new DataFormatter();
			SimpleDateFormat sf=new SimpleDateFormat();
			Date dt= new Date();
			int nouc=sh.getRow(0).getLastCellNum();
			Cell rc=sh.getRow(0).createCell(nouc);
			rc.setCellValue(sf.format(dt));
		}
		
	}
	public void saveAndCloseExcel() throws Exception
	{
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();
	}
	
	
	

}
