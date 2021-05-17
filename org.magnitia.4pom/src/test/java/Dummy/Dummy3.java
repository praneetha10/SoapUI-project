package Dummy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy3 {
	//Pom code for selecting an item in <select> tag dropdown
	//Locate Elements
	public ChromeDriver driver;
	@FindBy(how=How.XPATH,using="//span[text()='×']/parent::button")
	public WebElement s;
	@FindBy(how=How.XPATH,using="//*[name()='svg']//*[name()='g']//*[name()='circle']")
	public WebElement e;
	@FindBy(how=How.NAME,using="nights")
	public WebElement w;
	//Constuructor Method
	public Dummy3(ChromeDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void closeBanner1()
	{
		driver.switchTo().frame(1);
		e.click();
		driver.switchTo().defaultContent();
	}
	public void visiableText(String x)
	{
		Select s =new Select(w);
		s.selectByVisibleText(x);
		
	}
	public static void main(String[] args) throws Exception
	{
		//Open Browser 
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Dummy3 du=new Dummy3(driver);
		//Launch site
		driver.navigate().to("https://www.mercurytravels.co.in/");
		Thread.sleep(5000);
		//Locate element
		du.closeBanner1();
		Thread.sleep(5000);
		du.s.click();
		du.visiableText("10Nights+11Days");
		
		
		
	}

}
