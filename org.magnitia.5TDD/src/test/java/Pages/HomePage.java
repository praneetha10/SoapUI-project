package Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	//Properties
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	@FindBy(how=How.NAME,using="identifier")
	private WebElement  uid;
	@FindBy(how=How.XPATH,using="//span[text()='Next']/parent::button")
	private WebElement uidnext;
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Enter an email')]")
	private WebElement uidblank;
	@FindBy(how=How.XPATH,using="//div[contains(text(),'find your Google Account')]")
	private WebElement uiderr;
	@FindBy(how=How.XPATH,using="//div[text()=\"Enter your password\"]")
	private WebElement passwordvail;
	//Constructor methods
	public HomePage(RemoteWebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=wait;
	}
	//Operational methods to Operate elements
	public void uidFill(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(uid)).sendKeys(x);
	}
	public void uidnext()
	{
		wait.until(ExpectedConditions.elementToBeClickable(uidnext)).click();
	}
	public boolean isBlankuidError()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(uidblank));
			return (true);
		}
		catch(Exception ex)
		{
			return(false);
		}
	}
	public boolean isInvaliduidError()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(uiderr));
			return(true);
		}
		catch(Exception ex)
		{
			return(false);
		}
	}
	public boolean isPasswordDisplayed()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(passwordvail));
			return(true);
		}
		catch(Exception ex)
		{
			return (false);
		}
	
	}
	

}
