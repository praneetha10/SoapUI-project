package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import utility.Excelutility;
import utility.Testutility;

public class MailsentTest {

	public static void main(String[] args) throws Exception 
	{
		//Create object to  utility classes
		Testutility tu=new Testutility();
		String tdfpath=System.getProperty("user.dir")+"\\src\\test\\resources\\Book2.xlsx";
		Excelutility eu=new Excelutility(tdfpath);
		try
		{
			eu.OpenSheet("Sheet2");
			int nour=eu.getRowsCount();
			int nouc=eu.getColumnsCount();
			eu.creteResultColum(nouc);
			for(int i=1;i<nour;i++)
			{
				String bn=eu.getCellValue(i,0);
				String u= eu.getCellValue(i,1);
				String p=eu.getCellValue(i, 2);
				String t=eu.getCellValue(i,3);
				String s=eu.getCellValue(i,3);
				String b=eu.getCellValue(i,3);
				String fp=eu.getCellValue(i,3);
				//Open Browser
				RemoteWebDriver driver=tu.openBrowser(bn);
				//wait 
				WebDriverWait wait=tu.defineWait(driver);
				//create object for home pages
				HomePage hp=new HomePage(driver,wait);
				LoginPage lp=new LoginPage(driver,wait);
				ComposePage cp=new ComposePage(driver,wait);
				LogoutPage lop=new LogoutPage(driver,wait);
				//Launch site by using url in prpetries file
				String url=tu.getValueInPropertiesFile("url");
				tu.launchSite(url);
				//Do login using valid data
				hp.uidFill(u);
				hp.uidnextclick();
				Thread.sleep(5000);
				lp.pwdfill(p);
				lp.pwdnextclick();
				Thread.sleep(5000);
				try
				{
					cp.clickCompose();
					cp.fillTo(t);
					cp.fillSubject(s);
					cp.fillBody(b);
					cp.attachment(fp);
					cp.clickSend();
					//Compose Testing
					String msg=cp.getoutputMessage();
					if(!msg.contains("sorry"))
					{
						eu.setCellValue(i, nouc,"Compose test passed and we got"+msg);
					}
					else
					{
						eu.setCellValue(i, nouc,"Compose test failed and see"+tu.captureScreenShot());
						
					}
					//Do logout
					lop.clickProfilePic();
					lop.clickSignout();
					//close site
					tu.closeSite();
				}
				catch(Exception ex)
				{
					eu.setCellValue(i,nouc, ex.getMessage()+tu.captureScreenShot());
					tu.closeSite();
				}
			}
			eu.saveAndExcel();
		}
		catch(Exception ex)
		{
			eu.saveAndExcel();
			System.out.println(ex.getMessage());
		}
	}

}
