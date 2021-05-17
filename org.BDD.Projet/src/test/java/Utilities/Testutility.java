package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testutility 
{
	//properties 
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	//Constructor Method
	public Testutility()
	{
		driver=null;
		wait=null;
	}
	//Operational method
	public String getValuesInPropertiesFile(String propertyname) throws Exception
	{
		String fpath=System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties";
		FileInputStream fi=new FileInputStream(fpath);
		Properties p=new Properties();
		p.load(fi);
		String value=p.getProperty(propertyname);
		fi.close();
		return(value);
	}
	public RemoteWebDriver OpenBrowser(String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			System.setProperty("webdriver.chrome.silentOutput","true");
			co.addArguments("--disable-notifications");
			co.addArguments("--start-maximized");
			String[] s=new String[] {"enable-automation"};
			co.setExperimentalOption("excludeSwitches",s);
			driver=new ChromeDriver(co);
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		else
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		return(driver);
	}
	public WebDriverWait definewait(RemoteWebDriver driver) throws Exception
	{
		String temp=getValuesInPropertiesFile("maxwait");
		int max=Integer.parseInt(temp);
		wait=new WebDriverWait(driver,max);
		return(wait);
	}
	public void launchSite(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	public String captureScreensort() throws Exception
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt=new Date();
		String fn=System.getProperty("user.dir")+"\\target\\"+sf.format(dt)+".png";
		File dest=new File(fn);
		File src=driver.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, dest);
		return(dest.getAbsolutePath());
	}
	public void closeSite()
	{
		driver.quit();
	}
}
