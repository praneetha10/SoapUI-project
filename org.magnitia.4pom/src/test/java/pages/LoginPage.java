package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
	//Properties for locating elements
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	@FindBy(how=How.NAME,using="password")
	private WebElement pwd;
	@FindBy(how=How.XPATH,using="//span[text()='Next']/parent::button")
	private WebElement pwdnext;
	@FindBy(how=How.XPATH,using="//span[text()='Enter a password']")
	private WebElement blankpwd;
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Wrong password. Try again or click Forgot password')]")
	private WebElement invalidpwderr;
	//Constructor method for connecting woth runner class via association
	public LoginPage(RemoteWebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=wait;
	}
	//Operational methods to Operate elemets
	public void pwdfill(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(pwd)).sendKeys(x);
	}
	public void pwdnextclick()
	{
		wait.until(ExpectedConditions.elementToBeClickable(pwdnext)).click();
	}
	public boolean isBlankpwdError()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(blankpwd));
			return(true);
		}
		catch(TimeoutException ex)
		{
			return(false);
		}
	}
	public boolean isInvalidpwdError()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(invalidpwderr));
			return(true);
		}
		catch(TimeoutException ex)
		{
			return(false);
			
		}
		
	}
}
