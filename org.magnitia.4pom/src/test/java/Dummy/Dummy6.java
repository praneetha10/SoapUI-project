package Dummy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy6 
{
	//Hidden element
	public ChromeDriver driver;
	@FindBy(how=How.XPATH,using="//h4[text()='Multiple Search Selection']")
	WebElement e;
	@FindBy(how=How.XPATH,using="//h4[text()='Multiple Search Selection']/following::div[(@class='another dropdown example')][1]/div[2]")
	WebElement country;
	public void scrollTo()
	{
		driver.executeScript("arguments[0].scrollIntoView()",e);
	}
	public void dropDownCountry()
	{
		List<WebElement>items=country.findElements(By.xpath("child::div[2]/div"));
		for(WebElement item:items)
		{
			String x=(String)driver.executeScript("return(arguments[0].textContent);", item);
			System.out.println(x);
		}
	}
	public void selectByIndex(int i)
	{
		country.click();
		List<WebElement>items=country.findElements(By.xpath("child::div[2]/div/i"));
		if(items.size()<i)
		{
			System.out.println("wrong index");
			System.exit(0);;
		}
		else
		{
			items.get(i-1).click();
		}
		
		
	}
	//Constructor method
	public Dummy6(ChromeDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Dummy6 du=new Dummy6(driver);
		du.scrollTo();
		du.dropDownCountry();
		du.selectByIndex(10);
		
		
		
		

	}
	

}
