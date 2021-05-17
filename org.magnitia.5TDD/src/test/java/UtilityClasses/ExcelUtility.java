package UtilityClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	//Open File 
	//get Physical active rows 
	//create output column
	
	//Properties
	private File f;
	private FileInputStream fi;
	private Workbook wb;
	private Sheet sh;
	private FileOutputStream fo;
	//Constructor method
	public ExcelUtility (String filepath)throws Exception
	{
		f=new File(filepath);
		fi=new FileInputStream(f);
		wb= WorkbookFactory.create(fi);
		fo=new FileOutputStream(f);
	}
	//Operational Methods
	public void openSheet(String sheetname)
	{
		sh=wb.getSheet(sheetname);
	}
	public int getRowsCount()
	{
		int nour=sh.getPhysicalNumberOfRows();
		return(nour);
	}
	public int getColumnCount()
	{
		int nouc=sh.getRow(0).getLastCellNum();
		return(nouc);
	}
	public void createResultColumn(int colindex)
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyy-hh-mm-ss");
		Date df=new Date();
		Cell rc=sh.getRow(0).createCell(colindex);
		rc.setCellValue(sf.format(df));
	}
	public String getCellValue(int rowindex,int colindex)
	{
		DataFormatter df=new DataFormatter();
		String value=df.formatCellValue(sh.getRow(rowindex).getCell(colindex));
		return(value);
	}
	public void setCellValue(int rowindex,int colindex,String result)
	{
		Cell c=sh.getRow(rowindex).createCell(colindex);
		c.setCellValue(result);
		sh.autoSizeColumn(colindex);
	}
	public void saveAndColseExcel() throws Exception
	{
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();
	}
}

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

	
	
	
	
	


