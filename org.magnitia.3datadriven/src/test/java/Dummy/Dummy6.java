package Dummy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Dummy6 {

	public static void main(String[] args)throws Exception
	{
		File f=new File("F:\\batch 251\\selenium_framworks\\Frameworks\\org.magnitia.3datadriven\\target\\Book3.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("Sheet1");
		int nour=(int)sh.getPhysicalNumberOfRows();
		int nouc=(int)sh.getRow(0).getLastCellNum();
		sh.getRow(0).createCell(2).setCellValue("output");
		for(int i=1;i<nouc;i++)
		{
			int x=(int)sh.getRow(i).getCell(0).getNumericCellValue();
			int y=(int)sh.getRow(i).getCell(1).getNumericCellValue();
			
			
			int v=x*y;
			
			
			sh.getRow(i).createCell(2).setCellValue(v);

		
			
			
		}
		sh.autoSizeColumn(nouc);
		FileOutputStream fp=new FileOutputStream(f);
		wb.write(fp);
		wb.close();
		fp.close();
		
		
		
		
	}

}
