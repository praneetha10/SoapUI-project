package PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

public class BankManagerLogin 
{
	//properties
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	@FindBy(how=How.XPATH,using="//button[text()='Bank Manager Login']")
	private WebElement el;
	@FindBy(how=How.XPATH,using="//button[(contains(text(),'Add Customer'))]")
	private WebElement e2;
	@FindBy(how=How.XPATH,using="//input[@ng-model='fName']")
	private WebElement firstname;
	@FindBy(how=How.XPATH,using="//input[@ng-model='lName']")
	private WebElement lastname;
	@FindBy(how=How.XPATH,using="//input[@ng-model='postCd']")
	private WebElement postcard;
	@FindBy(how=How.XPATH,using="//button[text()='Add Customer']")
	private WebElement addcust;
	@FindBy(how=How.XPATH,using="//button[text()='Home']")
	private WebElement home;

	//constructor 
	public BankManagerLogin (RemoteWebDriver driver,WebDriverWait wait) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=wait;
	}
	//Operational method
	public void blmClick()
	{
		wait.until(ExpectedConditions.elementToBeClickable(el)).click();;
	}
	public void custmer()
	{
		wait.until(ExpectedConditions.elementToBeClickable(e2)).click();
	}
	public String firstname(String x)
	{
		ExpectedCondition<WebElement> ec=ExpectedConditions.visibilityOf(firstname);
		wait.until(ec).sendKeys(x);
		return x;
	}
	public String Lastname(String x)
	{
		ExpectedCondition<WebElement> ec=ExpectedConditions.visibilityOf(lastname);
		wait.until(ec).sendKeys(x);
		return x;
	}
	public void code(String pin)
	{
			wait.until(ExpectedConditions.visibilityOf(postcard)).sendKeys(pin);
	}
	public boolean custClick()
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(addcust)).click();
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
		
	}
	public Boolean isValidBlank()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addcust)).click();
		Screen s=new Screen();
		if(s.exists("\\src\\test\\resources\\Capture1.PNG")!=null)
		{
			return(true);
		}
		else
		{
			return(false);
		}
	} 
	public void Notification() throws Exception
	{
		Screen s=new Screen();
		s.click("src\\test\\resources\\Capture.PNG");
		Thread.sleep(5000);
	}
	public void homeButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(home)).click();
	}
	
	
}
