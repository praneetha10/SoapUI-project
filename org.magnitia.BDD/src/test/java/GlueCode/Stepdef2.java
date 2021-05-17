package GlueCode;

import java.io.File;
import java.io.FileInputStream;



import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pageclasses.ComposePage;
import Pageclasses.HomePage;
import Pageclasses.LoginPage;
import Pageclasses.LogoutPage;
import Utilityclasses.ExcelUtility;
import io.cucumber.java.en.And;


public class Stepdef2 
{
	//Declare objects to page classes and other required classes
	public HomePage hp;
	public LoginPage lp;
	public ComposePage cp;
	public LogoutPage lop;
	public Shared sh;
	public WebDriverWait wait;
	public ExcelUtility eu;
	 
	//Constructor method
	public Stepdef2 (Shared sh)
	{
		this.sh=sh;
	}
	//Operational methods of class with cucumber-java annotation
	@And("send mail and test by taking data from excel")
	public void method1() throws Exception
	{
		
		//Open execl file in read mode
		FileInputStream fs=new FileInputStream("F:\\batch 251\\selenium_framworks\\Frameworks\\org.magnitia.BDD\\src\\test\\resources\\Testdata\\Book2.xlsx"); //read the file
		Workbook wb=WorkbookFactory.create(fs);
		Sheet sheet=wb.getSheet("Sheet1");
		int nour=sheet.getPhysicalNumberOfRows();
		//oth row(first row) in excel file sheet is having names of columns
		for(int i=1;i<nour;i++)
		{	
				DataFormatter df=new DataFormatter();
				String to=df.formatCellValue(sheet.getRow(i).getCell(0));
				String subj=df.formatCellValue(sheet.getRow(i).getCell(1));
				String body=df.formatCellValue(sheet.getRow(i).getCell(2));
				String attachfile=df.formatCellValue(sheet.getRow(i).getCell(3));
				cp=new ComposePage(sh.driver,wait);
				cp.isCompose();
				cp.fillTo(to);
				cp.fillSubject(subj);
				cp.fillBody(body);
				cp.attachFile(attachfile);
				cp.sendMsg();
				//composing testing
				String msg=cp.getOutputmsg();
				if(!msg.contains("Sorry"))
				{
					sh.s.log("compose test passed and we got"+msg);
					Assert.assertTrue(true);
				}
				else
				{
					byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
					sh.s.attach(b,"image/png", "mail compose test failed");
					Assert.assertTrue(false);
				}
		}
		wb.close();
		fs.close();
		
	}

}
