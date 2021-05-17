package Dummy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Dummy7 {

	public static void main(String[] args) throws Exception 
	{
		//Connect to existing file in target folder with read
		File f=new File("F:\\batch 251\\selenium_framworks\\Frameworks\\org.magnitia.3datadriven\\target\\Book4.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("Sheet1");
		int nour=sh.getPhysicalNumberOfRows();
		int nouc=sh.getRow(0).getLastCellNum();
		System.out.println(nouc);
		//Row Sum
		
		for(int i=0;i<nour;i++)
		{
			int rowsum=0;
			for(int j=0;j<nouc;j++)
			{
				int x=(int)sh.getRow(i).getCell(0).getNumericCellValue();
				rowsum=rowsum+x;
			}
			sh.getRow(i).createCell(nouc).setCellValue(rowsum);
		}
		//cloumn sum
		for(int i=0;i<nouc;i++)
		{
			int colsum=0;
			for(int j=0;j<nour;j++)
			{
				int x=(int)sh.getRow(j).getCell(i).getNumericCellValue();
				colsum=colsum+x;
			}
			if(i==0)
			{
				sh.createRow(nour).createCell(i).setCellValue(colsum);
			}
			else
			{
				sh.getRow(nour).createCell(i).setCellValue(colsum);
			}
			sh.autoSizeColumn(i);
		}
		//Take write permission on that file save in HDD
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();

	}

}
