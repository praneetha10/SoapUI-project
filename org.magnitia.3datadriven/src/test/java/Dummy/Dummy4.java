package Dummy;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Dummy4 {

	public static void main(String[] args) throws Exception
	{
		try
		{
			//Open an existing excel file (.xlsx)in read mode
			File f=new File("F:\\batch 251\\selenium_framworks\\Frameworks\\org.magnitia.3datadriven\\target\\Book1.xlsx");
			FileInputStream fi=new FileInputStream(f);
			Workbook wb=WorkbookFactory.create(fi);
			Sheet sh=wb.getSheet("Sheet1");
			int nour=sh.getPhysicalNumberOfRows();
			System.out.println(nour);
			int nouc=sh.getRow(0).getLastCellNum();
			System.out.println(nouc);
			
			sh.getRow(0).createCell(2).setCellValue("output");
			for(int i=1;i<nour;i++)
			{
				int x=(int)sh.getRow(i).getCell(0).getNumericCellValue();
				int y=(int)sh.getRow(i).getCell(1).getNumericCellValue();
				int z=x+y;
				sh.getRow(i).createCell(2).setCellValue(z);
			}
			sh.autoSizeColumn(2);
			FileOutputStream fo=new FileOutputStream(f);
			wb.write(fo);
			wb.close();
			fo.close();
			
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		
		
		
		
	}

}
