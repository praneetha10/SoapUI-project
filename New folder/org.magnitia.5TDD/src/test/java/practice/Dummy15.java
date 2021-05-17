package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy15 
{
	public RemoteWebDriver driver;
	@Test(priority=1)
	public void method1()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@Test(priority=2)
	public void method2()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
}








