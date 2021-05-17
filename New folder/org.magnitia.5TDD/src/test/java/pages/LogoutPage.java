package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage 
{
	//Properties for locating elements
	private RemoteWebDriver driver;
	private WebDriverWait wait;
		
	@FindBy(how=How.XPATH,using="//a[starts-with(@aria-label,'Google Account')]/img")
	private WebElement profilepic;
		
	@FindBy(how=How.LINK_TEXT,using="Sign out")
	private WebElement signout;
	
	@FindBy(how=How.XPATH,using="//*[text()='Choose an account']")
	private WebElement relogin;
		
	//Constructor method for connecting with runner classes(via Association)
	public LogoutPage(RemoteWebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=wait;
	}
		
	//Operational methods to operate elements
	public void clickProfilePic()
	{
		wait.until(ExpectedConditions.elementToBeClickable(profilepic)).click();
	}
	
	public void clickSignOut()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signout)).click();
		wait.until(ExpectedConditions.visibilityOf(relogin));
	}
}

