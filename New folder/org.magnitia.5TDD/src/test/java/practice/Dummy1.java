package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy1 
{
	@Test(description="open browser",timeOut=5000)
	public void method() 
	{
		System.out.println("launch browser");
	}
}
