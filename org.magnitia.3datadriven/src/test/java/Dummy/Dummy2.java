package Dummy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dummy2 {

	public static void main(String[] args) throws Exception
    {
		//create file .xlsx and send data
		XSSFWorkbook wb=new XSSFWorkbook();
		Sheet sh=wb.createSheet();
		Row r=sh.createRow(0);
		Cell c=r.createCell(0);
		c.setCellValue("abdul kalam");
		//Save HDD
		sh.autoSizeColumn(0);
		File f=new File("target//dummy2.xlsx");
		FileOutputStream fo=new FileOutputStream(f);//take write permission
		wb.write(fo);
		wb.close();
		fo.close();
		
		
		
		
		

	}

}
