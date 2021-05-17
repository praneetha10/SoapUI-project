package Dummy;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SolveStaleIssue {
	//Properties
	public ChromeDriver driver;
	@FindBy(how=How.NAME,using="identifier")
	WebElement e;
	
	public SolveStaleIssue(ChromeDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//Main method to run
	public static void main(String[] args) throws Exception 
	{
		//Open Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		SolveStaleIssue obj=new SolveStaleIssue(driver);
		//Launch site
		driver.get("https://www.gmail.com");
		Thread.sleep(8000);
		//Locate an Element
		obj.e.sendKeys("magnitia251@gmail.com",Keys.ENTER);
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(5000);
		obj.e.clear();
		obj.e.sendKeys("prneeth",Keys.ENTER);	
	}

}
