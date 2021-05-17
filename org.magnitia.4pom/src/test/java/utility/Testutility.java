package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testutility 
{
	//Properties 
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	//constructor Mehtod
	public Testutility ()
	{
		driver=null;
		wait=null;
	}
	//Operational method
	//Properties file
	public String getValueInPropertiesFile(String propertyname) throws Exception
	{
		String pfpath=System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		FileInputStream fi=new FileInputStream(pfpath);
		Properties p=new Properties();
		p.load(fi);
		String value=p.getProperty(propertyname);
		fi.close();
		return(value);
	}
	public RemoteWebDriver openBrowser(String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firfox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		else
		{
			System.out.println("wrong browser");
			System.exit(0);
		}
		return(driver);
	}
	public WebDriverWait defineWait(RemoteWebDriver driver) throws Exception
	{
		String temp=getValueInPropertiesFile("maxwait");
		int max=Integer.parseInt(temp);
		wait=new WebDriverWait(driver,max);
		return(wait);
	}
	public void launchSite(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public String captureScreenShot() throws Exception
	{
	
			SimpleDateFormat df=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
			Date dt=new Date();
			String fn=System.getProperty("user.dir")+"\\target\\"+df.format(dt)+".png";
			File dest=new File(fn);
			File src=driver.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src,dest);
			return(dest.getAbsolutePath());
	}
	public void closeSite()
	{
		driver.close();
	}
}