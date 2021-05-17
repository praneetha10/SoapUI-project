package practice;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy16 
{
	public RemoteWebDriver driver;
	@Test(priority=1)
	public void method1()
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
}


















