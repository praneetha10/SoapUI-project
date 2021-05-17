package Framworks;

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
import org.openqa.selenium.ie.InternetExplorerDriver;
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
	//properties
	private RemoteWebDriver driver;
	private ExtentReports er;
	private ExtentTest et;
	//constructor methods
	public  ReuseableMethods(String bn)
	{
		//cross browser in local host
		if(bn.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(bn.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(bn.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(bn.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("wrong browser name");
			System.exit(0);
		}
		//create object for extent reports to save results in a "html"file
		er=new ExtentReports("target\\gmail\\testresults.html",false);
		et=er.startTest("Gmail site login testing in localhost");
	}
		public ReuseableMethods(String bn,String version,String os)
		{
			//Give cloud (sause labs)details
			String username="batch251";
			String Accesskey="e5250401-b996-4342-8c22-7484c6039d04";
			String uri="http://"+username+":"+Accesskey+"@ondemand.saucelabs.com:80/wd/hub";
			//Desired capabilites to give required Test Environment details
			try
			{
				DesiredCapabilities dc=new DesiredCapabilities();
				dc.setBrowserName(bn);
				dc.setCapability("version", version);
				if(os.equalsIgnoreCase("windows"))
				{
					dc.setCapability("platform", Platform.WIN10 );
				}
				else if(os.equalsIgnoreCase("mac"))
				{
					dc.setCapability("platform", Platform.MAC);
				}
				else if(os.equalsIgnoreCase("linux"))
				{
					dc.setCapability("platform", Platform.LINUX);
				}
				else
				{
					System.out.println("wrong os name");
					System.exit(0);
				}
				URL u=new URL(uri);
				driver =new RemoteWebDriver(u,dc);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				System.exit(0);;
			}
			//create object for extent reports to save reults in a html file
			er=new ExtentReports("target\\gmail\\testresults.html",false);
			et=er.startTest("Gmail site login testing in cloud");
			}
		//Operational methods
		public void launchsite(String url)throws Exception
		{
			Thread.sleep(5000);
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(5000);
		}
		public void fillandValidateLogin(String uid,String uc,String p,String pc)throws Exception
		{
			driver.findElement(By.name("identifier")).sendKeys(uid);
			driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
			Thread.sleep(5000);
			try
			{
				if(uc.equalsIgnoreCase("blank")&&driver.findElement(By.xpath("(//*[contains(text(),'Enter an email')])[2]")).isDisplayed())
				{
					et.log(LogStatus.PASS,"Blank userid test passed");
				}
				else if(uc.equalsIgnoreCase("invaild")&&driver.findElement(By.xpath("(//*[contains(text(),'Couldn't find your Google Account')][2]")).isDisplayed())
				{
					et.log(LogStatus.PASS,"Invaild uerid test passed");
				}
				else if(uc.equalsIgnoreCase("vaild")&& driver.findElement(By.name("password")).isDisplayed())
				{
					//password Tesing
					driver.findElement(By.name("password")).sendKeys(p);
					driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
					Thread.sleep(5000);
					if(pc.equalsIgnoreCase("blank")&&driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).isDisplayed())
					{
						et.log(LogStatus.PASS,"Blank password test passed");
					}
					else if(pc.equalsIgnoreCase("invaild")&&driver.findElement(By.xpath("contains(text(),'Wrong password.Try again']")).isDisplayed())
					{
						et.log(LogStatus.PASS,"Invaild password test password");
					}
					else if(pc.equalsIgnoreCase("vaild")&&driver.findElement(By.xpath("//*[text()='Compose']")).isDisplayed())
					{
						et.log(LogStatus.PASS,"vaild password");
					}
					else
					{
						et.log(LogStatus.FAIL, "password test failed"+et.addScreenCapture(screenshot()));
					}
				}
				else
				{
					et.log(LogStatus.FAIL,"Userid test failed and try to watch"+et.addScreenCapture(screenshot()));
				}
			}
	          
			catch(Exception ex)
			{
				et.log(LogStatus.FAIL,et.addScreenCapture(screenshot()));
			}
			
		}
		public void closeSite()
		{
			driver.close();
			er.flush();
			er.endTest(et);
		}
		private String screenshot()throws Exception
		{
			SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
			Date dt=new Date();
			String fn=sf.format(dt)+".png";	
			File dest=new File(fn);
			File src=driver.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, dest);
			return(dest.getAbsolutePath());
			
		}
		
		}
     

	


