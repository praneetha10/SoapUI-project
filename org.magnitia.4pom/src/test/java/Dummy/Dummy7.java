package Dummy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy7 {
	public ChromeDriver driver;
	@FindBy(how=How.XPATH,using="//h5[contains(text(),'India 2nd INNINGS ')]") 
	public WebElement wt;
	@FindBy(how=How.XPATH,using="//h5[contains(text(),'India 2nd INNINGS')]/following::table[@class='table batsman']")
	public WebElement e;
	//Operational method
	public int getRowCount()
	{
		int value=e.findElements(By.xpath("child::tbody/descendant::a/ancestor::tr")).size();
		return(value);
	}
	
	//Constructor method
	public void  scrollTo()
	{
		driver.executeScript("arguments[0].scrollIntoView()", wt);
	}
	public Dummy7(ChromeDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	

	public static void main(String[] args) 
	{
		//Open Browser and Launch
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.navigate().to("https://www.espncricinfo.com/series/india-in-australia-2020-21-1223867/australia-vs-india-3rd-test-1223871/full-scorecard");
		Dummy7 du=new Dummy7(driver);
		du.scrollTo();
		du.getRowCount();
		
		

	}

}
