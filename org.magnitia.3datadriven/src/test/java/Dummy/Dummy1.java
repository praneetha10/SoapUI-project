package Dummy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Dummy1 {

	public static void main(String[] args) throws Exception 
	{
		//create xls file and send data
		HSSFWorkbook wb=new HSSFWorkbook();
		Sheet sh=wb.createSheet();
		Row r=sh.createRow(0);
		Cell c=r.createCell(0);
		c.setCellValue("abdul kalam");
		//save HDD
		sh.autoSizeColumn(0);
		File fo =new File("target//dummy.xls");
		FileOutputStream fp=new FileOutputStream(fo);
		wb.write(fo);
		wb.close();
		fp.close();
		
		

	}

}
