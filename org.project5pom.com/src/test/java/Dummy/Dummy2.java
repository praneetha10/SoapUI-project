package Dummy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy2 {

	public static void main(String[] args) throws Exception 
	{
		//drop down
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://twhyderabad.github.io/demo_site/create-student.html");
		WebElement e=driver.findElement(By.xpath("//select[@id='class']"));
		Select s=new Select(e);
		List<WebElement>items=s.getOptions();
		for(WebElement item:items)
		{
			String x=item.getText();
			System.out.println(x);
			Thread.sleep(1000);
			item.click();
		}
		
		

	}

}
