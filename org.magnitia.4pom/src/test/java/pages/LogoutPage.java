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
	//Proprties
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	@FindBy(how=How.XPATH,using="//a[contains(@aria-label,'Google Account: ')]/img")
	private WebElement profpic;
	@FindBy(how=How.LINK_TEXT,using="Sign out")
	private WebElement signout;
	@FindBy(how=How.XPATH,using="//span[text()='Choose an account']")
	private WebElement relogin;
	//Constructor method for connecting with runner classes
	public LogoutPage(RemoteWebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=wait;
	}
	//Operational methods to Operate elements
	public void clickProfilePic()
	{
		wait.until(ExpectedConditions.elementToBeClickable(profpic)).click();
	}
	public void clickSignout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signout)).click();
		wait.until(ExpectedConditions.visibilityOf(relogin));
	}
	

}
