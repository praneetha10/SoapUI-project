package Pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	@FindBy(how=How.NAME,using="password")
	private WebElement pwd;
	@FindBy(how=How.XPATH,using="//span[text()='Next']/parent::button")
	private WebElement pwdnext;
	@FindBy(how=How.XPATH,using="//span[text()='Enter your password']")
	private WebElement pwdblankerr;
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Wrong password. Try again')]")
	private WebElement pwderror;
	
	
	//Constructor Method
	public LoginPage(RemoteWebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait=wait;
	}
	
	//Operational method
	public void isPassword(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(pwd)).sendKeys(x);
	}
	public void isNextpwd()
	{
		wait.until(ExpectedConditions.elementToBeClickable(pwdnext)).click();
	}
	public boolean isBlankpwd()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(pwdblankerr));
			return true;
		}
		catch(Exception ex)
		{
			
			return false;
		}
	}
	public boolean ispwdError()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(pwderror));
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	
}
