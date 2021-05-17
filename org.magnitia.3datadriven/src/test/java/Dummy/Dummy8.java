package Dummy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Dummy8 {

	public static void main(String[] args) throws Exception
	{
		File f=new File("target\\Book6.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("Sheet1");
		int nour=(int)sh.getPhysicalNumberOfRows();
		System.out.println(nour);
		int nouc=(int)sh.getRow(0).getLastCellNum();
		System.out.println(nouc);
		for(int i=0;i<nour;i++)
		{
			int rowmax=(int)sh.getRow(i).getCell(0).getNumericCellValue();
			for(int j=0;j<nouc;j++)
			{
				int x=(int)sh.getRow(i).getCell(j).getNumericCellValue();
				if(rowmax<x)
				{
					rowmax=x;
				}
				
			}
			sh.getRow(i).createCell(nouc).setCellValue(rowmax);
		}
		//column max
		for(int i=0;i<nouc;i++)
		{
			int colmax=(int)sh.getRow(0).getCell(i).getNumericCellValue();
			for(int j=1;j<nour;j++)
			{
				int x=(int)sh.getRow(j).getCell(i).getNumericCellValue();
				if(colmax<x)
				{
					colmax=x;
				}
			}
			if(i==0)
			{
				sh.createRow(nour).createCell(i).setCellValue(colmax);
			}
			else
			{
				sh.getRow(nour).createCell(i).setCellValue(colmax);
			}
			sh.autoSizeColumn(i);
		}
		//Take write perission on that file
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
		
		
		

	}

}
