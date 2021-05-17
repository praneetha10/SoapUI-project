package Dummy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy10 {

	public static void main(String[] args) throws Exception
	{
		//Open an existing excel file(.xlsx) in read mode
		File f=new File("target\\dummy10.xlsx");
		Workbook wb=WorkbookFactory.create(f);
		Sheet sh=wb.getSheet("Sheet1");
		int nour=sh.getPhysicalNumberOfRows();
		int nouc=sh.getRow(0).getLastCellNum();
		//create result column
		sh.getRow(0).createCell(nouc).setCellValue("actual");
		sh.getRow(0).createCell(nouc+1).setCellValue("Result");
		//Date driven from 2nd row index
		for(int i=1;i<nour;i++)
		{
			String equation=sh.getRow(i).getCell(0).getStringCellValue();		
			double expected=sh.getRow(i).getCell(1).getNumericCellValue();
			//Launch site
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("https://www.calculator.net/");
			Thread.sleep(5000);
			if(equation.startsWith("cos"))
			{
				driver.findElement(By.xpath("(//span[text()='cos'])[1]")).click();
				Thread.sleep(5000);
			}
			else if(equation.startsWith("sin"))
			{
				driver.findElement(By.xpath("(//span[text()='sin'])[1]")).click();
				Thread.sleep(5000);
			}
			else
			{
				driver.findElement(By.xpath("(//span[text()='sin'])[1]")).click();
				Thread.sleep(5000);
			}
			//Seperate value from equation
			String value=equation.substring(4,equation.length()-1);
			//Seperate each digit in value to click on related buttom
			for(int j=0;j<value.length();j++)
			{
				char d=value.charAt(j);
				driver.findElement(By.xpath("(//span[text()='"+d+"'])[1]")).click();
				Thread.sleep(8000);
			}
			driver.findElement(By.xpath("(//span[text()='='])[1]")).click();
			Thread.sleep(5000);
		
			String temp=driver.findElement(By.id("sciOutPut")).getText();
			temp=temp.trim();
			double actual=Double.parseDouble(temp);
			driver.close();
			sh.getRow(i).createCell(nouc).setCellValue(actual);
			//validation
			if(expected==actual)
			{
				sh.getRow(i).createCell(nouc+1).setCellValue("Test passed");
			}
			else
			{
				sh.getRow(i).createCell(nouc+1).setCellValue("Test failed");
			}
			
		}
		//save results
		sh.autoSizeColumn(nouc);
		sh.autoSizeColumn(nouc+1);
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		fo.close();
	}

}
