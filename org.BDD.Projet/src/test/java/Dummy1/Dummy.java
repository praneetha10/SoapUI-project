package Dummy1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions co=new ChromeOptions();
		System.getProperty("webdriver.chrome.silentOutput","true");
		co.addArguments("--disable-notifications");
		co.addArguments("--start-maximized");
		String[] s=new String[] {"enable-automation"};
		co.setExperimentalOption("excludeSwitches", s);
		ChromeDriver driver=new ChromeDriver(co);
		
		//Launch site
		driver.navigate().to("https://www.espncricinfo.com/series/india-in-australia-2020-21-1223867/australia-vs-india-3rd-test-1223871/full-scorecard");
		//scroll into
		WebElement e1=driver.findElement(By.xpath("//h5[text()='India 1st INNINGS ']"));
		driver.executeScript("arguments[0].scrollIntoView();", e1);

	}
	
}
