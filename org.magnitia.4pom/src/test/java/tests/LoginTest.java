package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import utility.Excelutility;
import utility.Testutility;

public class LoginTest {

	public static void main(String[] args) throws Exception
	{
		//create objects to utility classes
		Testutility tu=new Testutility();
		String tdfpath=System.getProperty("user.dir")+"\\src\\test\\resources\\Book1.xlsx";
		System.out.println(tdfpath);
		Excelutility  eu=new Excelutility (tdfpath);
		try
		{
			//Acces excel file sheet for Test data
			eu.OpenSheet("Sheet1");
			int nouc=eu.getRowsCount();
			System.out.println(nouc);
			int nour=eu.getColumnsCount();
			eu.creteResultColum(nouc);
			//Login functional testing with multiple test data  in cross browser environment
			for(int i=1;i<nour;i++)
			{
				String bn=eu.getCellValue(i, 0);
				String u=eu.getCellValue(i, 1);
				String uc=eu.getCellValue(i, 2);
				String p=eu.getCellValue(i,3);
				String pc=eu.getCellValue(i,4);
				//Open browser by creating driver object 
				RemoteWebDriver driver=tu.openBrowser(bn);
				//define wait object by using driver object
				WebDriverWait wait=tu.defineWait(driver);
				//create object to page classes by using driver and wait object
				HomePage hp=new HomePage(driver,wait);
				LoginPage lp=new LoginPage(driver,wait);
				ComposePage cp=new ComposePage(driver,wait);
				LogoutPage lop=new LogoutPage(driver,wait);
				//Launch site by using url in properties file
				String url=tu.getValueInPropertiesFile("url");
				tu.launchSite(url);
				//user id testing
				try
				{
					//Enter userid and Click next
					hp.uidFill(u);
					hp.uidnextclick();
					if(u.length()==0)
					{
						if(hp.isBlankuidError())
						{
							eu.setCellValue(i,nouc,"uid blank test passed");
						}
						else
						{
							eu.setCellValue(i,nouc,"uid blank test failed and see"+tu.captureScreenShot());
						}
					}
					else if(u.length()!=0 &&uc.equalsIgnoreCase("invalid"))
					{
						if(hp.isInvaliduidError())
						{
							eu.setCellValue(i, nouc, "Invalid UId test passed");
						}
						else
						{
							eu.setCellValue(i,nouc,"Invalid uidtest failed and see"+tu.captureScreenShot());
						}
					}
					else
					{
						//password testing
						try
						{
							//Fill password and click next
							lp.pwdfill(p);
							lp.pwdnextclick();
							if(p.length()==0)
							{
								if(lp.isBlankpwdError())
								{
									eu.setCellValue(i, nouc,"pwd blank test passed");
								}
								else
								{
									eu.setCellValue(i, nouc,"pwd blank test failed and see"+tu.captureScreenShot());
								}
							}
							else if(p.length()!=0&& pc.equalsIgnoreCase("invalid"))
							{
								if(lp.isInvalidpwdError())
								{
									eu.setCellValue(i,nouc,"invalid pwd test passed");
								}
								else
								{
									eu.setCellValue(i,nouc, "Invalid pwd failed and see"+tu.captureScreenShot());
								}
							}
							else
							{
								if(cp.isComposeVisible())
								{
									eu.setCellValue(i,nouc,"valid pwd test passed");
									//Do logout
									lop.clickProfilePic();
									lop.clickSignout();
								}
								else
								{
									eu.setCellValue(i,nouc,"valid pwd test failed and see"+tu.captureScreenShot());
								}
							}
							
						}
						catch(Exception ex)
						{
							eu.setCellValue(i,nouc,ex.getMessage()+tu.captureScreenShot());
							
						}
					}
					tu.closeSite();
				}
				catch(Exception ex1)
				{
					eu.setCellValue(i,nouc,ex1.getMessage()+tu.captureScreenShot());
					tu.closeSite();
				}
			}
			eu.saveAndExcel();;
		}
		catch(Exception ex2)
		{
			eu.saveAndExcel();
			System.out.println(ex2.getMessage());
		}
	}

}
