package Dummy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dummy9 {

	public static void main(String[] args) throws Exception 
	{
		//Open a folder and collect contents (sub folder and files of that folder)
		File f=new File("F:\\batch 251");
		File[] l=f.listFiles();
		//create new excel file(.xlsx)
		XSSFWorkbook wb=new XSSFWorkbook();
		Sheet sh=wb.createSheet("result");
		sh.createRow(0).createCell(0).setCellValue("Name");
		sh.getRow(0).createCell(1).setCellValue("file\folder");
		sh.getRow(0).createCell(2).setCellValue("file size");
		sh.getRow(0).createCell(3).setCellValue("last modified");
		sh.getRow(0).createCell(4).setCellValue("Hidden");
		//write all files names and other details into excels sheet's 2nd row(index=1)on wards
		int rownum=1;
		for(File f1:l)
		{
			sh.createRow(rownum).createCell(0).setCellValue(f1.getName());
			if(f1.isFile())
			{
				sh.getRow(rownum).createCell(1).setCellValue("file");
				double b=f.length();
				double k=(b/1024);
				sh.getRow(rownum).createCell(2).setCellValue(k+"kb");
			}
			else
			{
				sh.getRow(rownum).createCell(1).setCellValue("folder");
				long b=FileUtils.sizeOfDirectory(f);
				double k=(b/1024);
				sh.getRow(rownum).createCell(2).setCellValue(k+"kb");
			}
			SimpleDateFormat sdf=new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss");
			sh.getRow(rownum).createCell(3).setCellValue(sdf.format(f.lastModified()));
			//Hidden or not
			if(f.isHidden())
			{
				sh.getRow(rownum).createCell(4).setCellValue("yes");
			}
			else
			{
				sh.getRow(rownum).createCell(4).setCellValue("No");
				
			}
			rownum=rownum+1;
		}
			//Take write permission on that file
			int nouc=sh.getRow(0).getLastCellNum();
			for(int i=0;i<nouc;i++)
			{
				sh.autoSizeColumn(i);
			}
			File f2=new File("target\\Resultbook.xlsx");
			FileOutputStream fo=new FileOutputStream(f2);
			wb.write(fo);
			wb.close();
			fo.close();
			}

	}
