package Dummy;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy2{

	public static void main(String[] args) throws Exception
	{		WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver(); 
			
			driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-lg'])[1]")).click();
			Thread.sleep(5000);
			List<WebElement>ele=driver.findElements(By.xpath("//select[@ng-model='custId']"));
			
			for(WebElement e:ele)
			{
				e.click();
				System.out.println(e.getText());
			}
			driver.close();
	}
}