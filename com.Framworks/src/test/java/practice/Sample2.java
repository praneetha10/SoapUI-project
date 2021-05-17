package practice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sample2 {

	public static void main(String[] args) 
	{
		//create a new excel file(.xlsx)
		XSSFWorkbook wb=new XSSFWorkbook();
		Sheet sh=wb.createSheet("MySheet");
		Row r=sh.createRow(0);
		Cell c=r.createCell(0);
		
		
		

	}

}
