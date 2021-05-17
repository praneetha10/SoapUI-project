package Dummy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy5 
{
	public ChromeDriver driver;
	@FindBy(how=How.XPATH,using="//h4[text()='Multiple Selection']")
	public WebElement e;
	@FindBy(how=How.XPATH,using="//h4[text()='Multiple Selection']/following-sibling::div")
	public WebElement skills;
	public void scrolltoElement()
	{
		driver.executeScript("arguments[0].scrollIntoView();",e);
	}
	public void multiDropDrown()
	{
		//is single select drop down or multi select select dropdown
		if(skills.getAttribute("class").contains("multiple"))
		{
			System.out.println("multi-select dropdown");
		}
		else
		{
			System.out.println("single select dropdown");
		}
	}
	public void dropdownauto() throws Exception
	{
		skills.click();
		List<WebElement>items=skills.findElements(By.xpath("child::div[2]/div"));
		for(WebElement item:items)
		{
			if(item.isDisplayed())
			{
				String x=item.getText();
				System.out.println(x);
				Thread.sleep(2000);
				item.click();
				Thread.sleep(2000);
			}
			skills.findElement(By.xpath("child::a/i")).click();
			Thread.sleep(5000);
		}
		
	}
	
	//constructor method
	public  Dummy5(ChromeDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public static void main(String[] args) throws Exception 
	{
		//Open Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		Dummy5  du =new Dummy5(driver);
		Thread.sleep(5000);
		driver.navigate().to("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		du.scrolltoElement();
		du.multiDropDrown();
		du.dropdownauto();
	}

}
