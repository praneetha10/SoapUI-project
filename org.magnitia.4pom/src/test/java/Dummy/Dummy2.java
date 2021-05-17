package Dummy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy2 {
	//Locator Property
	public ChromeDriver driver;
	@FindBy(how=How.NAME,using="identifier")
	public WebElement s;
	@FindBy(how=How.XPATH,using="//span[text()='Next']/parent::button")
	public WebElement e;
	//constructr method
	public Dummy2(ChromeDriver driver)
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
		Dummy2 obj=new Dummy2(driver);
		//launch site
		driver.get("https://www.gmail.com");
		Thread.sleep(8000);
		//Locate Element 
		obj.s.sendKeys("magnitia251@gmail.com");
		Thread.sleep(5000);
		obj.e.click();
		
	}

}
