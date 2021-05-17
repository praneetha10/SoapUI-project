package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageClass.HomePage;
import PageClass.LoginPage;
import Utilityclasses.TestUtilities;
import Utilityclasses.excelutility;

public class Runner1 {
	public static void main(String[] args) throws Exception 
	{
		TestUtilities  tu=new TestUtilities ();
		String fpath=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata.xlsx";
		excelutility  eu=new excelutility (fpath);
		try
		{
			eu.openSheet("Sheet1");
			int nour=eu.getColumnsCount();
			int nouc=eu.getRowsCount();
			eu.createResultColumn(nouc);
			for(int i=1;i<nour;i++)
			{
				String bn=eu.getCellValue(i,0);
				String u=eu.getCellValue(i,1);
				System.out.println(u);
				String p1=eu.getCellValue(i,2);
				System.out.println(p1);
				String uc=eu.getCellValue(i,3);
				RemoteWebDriver driver =tu.openBrowser(bn);
				WebDriverWait wait=tu.definewait(driver);
				HomePage hp=new HomePage(driver,wait);
				LoginPage lp=new LoginPage (driver,wait);
				//Launch site by using url in properties file
				String url=tu.getValueInPropertiesFile("url");
				tu.launchSite(url);
				try
				{
					hp.validuerid(u);
					hp.validpwd(p1);
					hp.clickSubmit();
					if(u.length()==0)
					{
						if(hp.isBlankusiderr())
						{
							eu.setCellValue(i,nouc,"uid blank test passed");
						}
					}
					if(uc.equalsIgnoreCase("valid"))
					{
						if(hp.isDisplayed())
						{
							eu.setCellValue(i, nouc,"valid userid and password");
						}
						
					}
					else if(u.length()!=0 && uc.equalsIgnoreCase("invalid"))
					{
						
						if(hp.invalidcretira())
						{
							eu.setCellValue(i, nouc,"invalid test passed");
						}
					}
					
					
					else
					{
						eu.setCellValue(i, nouc,"Invaid uid test failed and see"+tu.captureScreenshort());
					}
				}
				
				catch(Exception ex)
				{
					eu.saveAndCloseExcel();
					System.out.println(ex.getMessage());
				}
				tu.closeSite();
			}
			eu.saveAndCloseExcel();
	}
		catch(Exception ex)
		{
			eu.saveAndCloseExcel();
			System.out.println(ex.getMessage());
		}
	}
		
}