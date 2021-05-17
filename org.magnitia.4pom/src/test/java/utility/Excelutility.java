package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excelutility 
{
	//Properties
	private File f;
	private FileInputStream fi;
	private Workbook wb;
	private Sheet sh;
	private FileOutputStream fo;
	//constuctor Methods
	public Excelutility (String filepath) throws Exception
	{
		f=new File(filepath);
		fi=new FileInputStream(f);
		wb=WorkbookFactory.create(fi);
		fo=new FileOutputStream(f);
	}
	//Operational methods
	public void OpenSheet(String sheetname)
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
	public void creteResultColum(int colindex)
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt=new Date();
		Cell rc=sh.getRow(0).createCell(colindex);
		rc.setCellValue(sf.format(dt));
	}
	public String getCellValue(int rowindex,int colindex)
	{
		DataFormatter dt=new DataFormatter();
		String value=dt.formatCellValue(sh.getRow(rowindex).getCell(colindex));
		return(value);
	}
	public void setCellValue(int rowindex,int colindex,String result)
	{
		Cell c=sh.getRow(rowindex).createCell(colindex);
		c.setCellValue(result);
		sh.autoSizeColumn(colindex);
	}
	public void saveAndExcel()throws Exception
	{
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();
	}
	
	
	
	
	
	

}
