package Dummy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Dummy5 {

	public static void main(String[] args) throws Exception
	{
		File f=new File("F:\\batch 251\\selenium_framworks\\Frameworks\\org.magnitia.3datadriven\\target\\Book2.xlsx");
		FileInputStream fs=new FileInputStream(f); //read the file
		Workbook wb=WorkbookFactory.create(fs);
		Sheet sh=wb.getSheet("Sheet1");
		int nour=sh.getPhysicalNumberOfRows();
		int nouc=sh.getRow(0).getLastCellNum();
		sh.getRow(0).createCell(2).setCellValue("output");
		for(int i=1;i<nour;i++)
		{
			int x=(int)sh.getRow(i).getCell(0).getNumericCellValue();
			int y=(int)sh.getRow(i).getCell(1).getNumericCellValue();
			int z=x-y;
			sh.getRow(i).createCell(2).setCellValue(z);
		}
		sh.autoSizeColumn(nouc);
		FileOutputStream fi=new FileOutputStream(f);
		wb.write(fi);
		wb.close();
		fi.close();
	}

}
