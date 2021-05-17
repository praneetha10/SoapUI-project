package Reusable;

import java.io.File;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ReuseableMethods 
{
	
		//Properties
		private RemoteWebDriver driver;
		private ExtentReports er;
		private ExtentTest et;
		//COnstructor Methods
		public ReuseableMethods (String bn)
		{
			if(bn.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				driver.manage().window().maximize();
			}
			else if(bn.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				 driver=new FirefoxDriver();
				 driver.manage().window().maximize();
			}
			else if(bn.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				driver.manage().window().maximize();
			}
			
			else
			{
				System.out.println("wrong Browser");
				System.exit(0);
			}
			er=new ExtentReports("target//gmailtestresults.html",false);
			et=er.startTest("gamil login in local host");
		}
		public ReuseableMethods(String bn,String version,String os)
		{
			String user_name="pranee10";
			String acess_key="e364716c-bac2-4f21-9a64-6c9c56895dcf";
			String uri="http://"+user_name+":"+acess_key+"@ondemand.saucelabs.com:80/wd/hub";
			try
			{
				DesiredCapabilities dc=new DesiredCapabilities();
				dc.setBrowserName(bn);
				dc.setCapability("Version", version);
				if(os.equalsIgnoreCase("window"))
				{
					dc.setCapability("platform", Platform.WIN8);
				}
				else if(os.equalsIgnoreCase("mac"))
				{
					dc.setCapability("platform",Platform.MAC);
				}
				else if(os.equalsIgnoreCase("Linux"))
				{
					dc.setCapability("platform",Platform.LINUX);
				}
				else
				{
					System.out.println("wrong platform");
					System.exit(0);
				}
				URL u=new URL(uri);
				driver=new RemoteWebDriver(u,dc);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				System.exit(0);
			}
			er=new ExtentReports("target//gmailtestresults.html",false);
			et=er.startTest("gmailsite on cloud");
		}
		public void launchSite(String url) throws Exception
		{
			
				Thread.sleep(5000);
				driver.navigate().to(url);
				driver.manage().window().maximize();
				Thread.sleep(5000);
		}
		public void fillAndValidate(String uid,String uc,String pwd,String pc) throws Exception
		{
			driver.findElement(By.name("identifier")).sendKeys(uid);
			driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
			Thread.sleep(5000);
			try
			{
				if(uc.equalsIgnoreCase("blank")&&driver.findElement(By.xpath("(//*[contains(text(),'Enter an email')])[2])")).isDisplayed())
				{
					et.log(LogStatus.PASS,"Blank userid test paassed");
				}
				else if(uc.equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("//*[contains(text(),'Couldn’t find your ')]")).isDisplayed())
				{
					et.log(LogStatus.PASS, "Invaild userid test passed");
				}
				else if(uc.equalsIgnoreCase("valid")&&driver.findElement(By.name("password")).isDisplayed())
				{
					//password Testing
					driver.findElement(By.name("password")).sendKeys(pwd);
					driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
					Thread.sleep(5000);
					if(uc.equalsIgnoreCase("blank")&&driver.findElement(By.xpath("(//*[contains(text(),'Enter a password')])[2]")).isDisplayed())
					{
						et.log(LogStatus.PASS, "Blank password Test passed");
					}
					else if(pc.equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("//*[contains(text(),'Wrong password')or"+"contains(text(),'Your password was changed')]")).isDisplayed())
					{
						et.log(LogStatus.PASS,"Invalid password test passed");
					}
				
					else if(uc.equalsIgnoreCase("valid")&&driver.findElement(By.xpath("//*[text()='Compose']")).isDisplayed())
					{
						et.log(LogStatus.PASS, "valid password");
					}
					else
					{
						et.log(LogStatus.FAIL,"password test fail"+et.addScreenCapture(screenshot()));
					
					}
				
				}
				else
				{
					et.log(LogStatus.FAIL,"userid test failed and try to watch"+et.addScreenCapture(screenshot()));
				}
				
				
		}
			catch(Exception ex)
			{
				//take Screen sort 
				et.log(LogStatus.FAIL,ex.getMessage()+et.addScreenCapture(screenshot()));
				
			}
			
		}
		public void closeSite()
		{
			driver.quit();
			er.flush();
			er.endTest(et);
			
		}
		private String screenshot() throws Exception 
		{
			
				SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
				Date dt=new Date();
				String fn=sf.format(dt)+".png";
				File dest=new File(fn);
				File src= driver.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(src,dest);
				return (dest.getAbsolutePath());
				
			
			
		}
}
