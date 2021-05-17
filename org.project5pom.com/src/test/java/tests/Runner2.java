package tests;

import java.util.Arrays;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageClass.HomePage;
import PageClass.LoginPage;
import Utilityclasses.TestUtilities;
import Utilityclasses.excelutility;

public class Runner2 
{
	public static void main(String[] args) throws Exception
	{
		//create objects to utility classes
		TestUtilities tu=new TestUtilities ();
		String tdfpath=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata.xlsx";
		excelutility eu=new excelutility (tdfpath);
		try
		{
			//Acess excel file sheet for test data
			eu.openSheet("Sheet2");
			int nour=eu.getRowsCount();
			int nouc=eu.getColumnsCount();
			eu.createResultColumn(nouc);
			for(int i=1;i<nour;i++)
			{
				String bn=eu.getCellValue(i,0);
				String u=eu.getCellValue(i,1);
				String p=eu.getCellValue(i,2);
				String na=eu.getCellValue(i,3);
				String rol=eu.getCellValue(i,4);
				RemoteWebDriver driver =tu.openBrowser(bn);
				WebDriverWait wait=tu.definewait(driver);
				HomePage hp=new HomePage(driver,wait);
				LoginPage lp=new LoginPage (driver,wait);
				//Launch site by using url in  properties file
				String url=tu.getValueInPropertiesFile("url");
				tu.launchSite(url);
				hp.validuerid(u);
				hp.validpwd(p);
				hp.clickSubmit();
				lp.nextPage();
				lp.username(na);
				lp.rollnum(rol);
				eu.validateDropdown();
				
			}
		}
		catch(Exception ex)
		{
			
			
		}
		
		
	}

}
