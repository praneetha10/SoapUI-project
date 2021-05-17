package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	//Properties
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	@FindBy(how=How.NAME,using="password")
	private WebElement pwd;
	@FindBy(how=How.XPATH,using="//span[text()='Next']/parent::button")
	private WebElement pwdnext;
	@FindBy(how=How.XPATH,using="//span[text()='Enter a password']")
	private WebElement pwdblank;
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Wrong password. Try again')]")
	private WebElement pwderr;
	//Constructor methods 
	public LoginPage(RemoteWebDriver driver,WebDriverWait wait)
	{ 
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait=wait;
	}
	//Operational Methods
	public void pwdFill(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(pwd)).sendKeys(x);;
	}
	public void pwdnext()
	{
		wait.until(ExpectedConditions.elementToBeClickable(pwdnext)).click();;
	}
	public boolean isBlankpwderror()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(pwdblank));
			return(true);
		}
		catch(Exception ex)
		{
			return(false);
		}
	}
	public boolean isInvalidpwdError()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(pwderr));
			return(true);
		}
		catch(Exception ex)
		{
			return(false);
		}
	}
}
