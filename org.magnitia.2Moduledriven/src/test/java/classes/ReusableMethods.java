package classes;

import java.io.File;
import java.io.IOException;
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

public class ReusableMethods
{
	//Properties
	private RemoteWebDriver driver;
	private ExtentReports er;
	private ExtentTest et;
	//Constructor methods (classes name and method name same)
	public ReusableMethods(String bn)
	{
		//cross browser in local host
		if(bn.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();//create object using child class construtor
		}
		
		else if(bn.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(bn.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		else if(bn.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Wrong output");
			System.exit(0);
		}
		//create object for extent reports to save results in a html
		er=new ExtentReports("target//gmailtestreults.html",false);
		et=er.startTest("Gmail site login testing in localhost");
	}
	public ReusableMethods(String bn,String version,String os)
	{
		//Give cloud(sause labs) details
		String user_name="pranee10";
		String Accesskey="e364716c-bac2-4f21-9a64-6c9c56895dcf";
		String uri="http://"+user_name+":"+Accesskey+"@ondemand.saucelabs.com:80/wd/hub";
		//Desired capabilites to give required Test environment details
		try
		{
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setBrowserName(bn);
			dc.setCapability("Version",version);
			if(os.equalsIgnoreCase("windows"))
			{
				dc.setCapability("platform",Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				dc.setCapability("platform",Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				dc.setCapability("platform",Platform.MAC);
			}
			else
			{
				System.out.println("wrong os name");
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
		//create object for extent reports to save reults in a html file
		er=new ExtentReports("target//gmailtestreults.html",false);//append results true means override
		et=er.startTest("Gmail site login testing in cloud");
	}
	//Operational Methods
	public void launchsite(String url) throws Exception
	{
		Thread.sleep(5000);
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	public void FillAndValidateLogin(String uid,String uc,String p,String pc) throws Exception
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
				driver.findElement(By.name("password")).sendKeys(p);
				driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
				Thread.sleep(5000);
			if(uc.equalsIgnoreCase("valid")&&driver.findElement(By.xpath("(//*[contains(text(),'Enter a password')])[2]")).isDisplayed())
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
	//close site
	public void closesite()
	{
		driver.close();
		er.flush();//save results
		er.endTest(et);
	}
	private String screenshot() throws Exception
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-mmm-yyyy-hh-mm-ss");
		Date dt=new Date();
		String fn=sf.format(dt)+".png";
		File dest=new File(fn);
		File src=driver.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, dest);
		return (dest.getAbsolutePath());
	}
	
	    
	

}
