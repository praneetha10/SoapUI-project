package Dummy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy4 
{
	public ChromeDriver driver;
	@FindBy(how=How.XPATH,using="//h4[text()='Selection']")
	public WebElement e;
	@FindBy(how=How.XPATH,using="//h4[text()='Selection']/following-sibling::div[2]")
	public WebElement gender;
	public void selectItemByIndex(int x) throws Exception
	{
		gender.click();//Open drop down
		Thread.sleep(5000);
		List<WebElement>items=gender.findElements(By.xpath("child::div[2]/div"));
		if(items.size()<x)
		{
			System.out.println("wrong index");
			System.exit(0);
		}
		else
		{
			items.get(x-1).click();
		}
	}
		
		public void selectItemByName(String m)throws Exception
		{
			gender.click();//Open drop down
			Thread.sleep(5000);
			List<WebElement>items=gender.findElements(By.xpath("child::div[2]/div"));
			int flag=0;
			for(WebElement item:items)
			{
				if(item.getText().equalsIgnoreCase(m))
				{
					item.click();
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				System.out.println("wrong item name");
				System.exit(0);
			}
		}
		public void scrollto()
		{
			driver.executeScript("arguments[0].scrollIntoView();", e);
			
		}
		//Constructor method
		public Dummy4(ChromeDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
	public static void main(String[] args) throws Exception 
	{
		//Open Chrome Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Dummy4 du=new Dummy4(driver);
		//Launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		du.scrollto();
		du.selectItemByIndex(1);
		du.selectItemByName("female");
		
		
		

	}

}
