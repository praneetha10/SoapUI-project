package Dummy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy1 {
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://twhyderabad.github.io/demo_site/create-student.html");
		List<WebElement> e=driver.findElements(By.xpath("//input[@type='radio' and @name='gender']"));
		System.out.println("count of items in drop down"+ e.size());
		System.out.println("items are:");
		for(WebElement radio:e)
		{
			
			String x=radio.getAttribute("value");
			System.out.println(x);
		}
		//select each item and test that selection
		for(WebElement radio:e)
		{
			try
			{
				if(radio.isDisplayed())
				{
					System.out.println("element is visiable in page");
					if(radio.isEnabled())
					{
						System.out.println("element is enabled in page");
						if(radio.isSelected())
						{
							System.out.println("element is selected in page");
						}
						else
						{
							System.out.println("element is not selected in page");
						}
					}
					else
					{
						System.out.println("element is disabled in page");
					}
				}
				else
				{
					System.out.println("element is not visiable in page");
				}
				
			}
			catch(Exception ex)
			{
				ex.getMessage();
			}
		}
	}

}
