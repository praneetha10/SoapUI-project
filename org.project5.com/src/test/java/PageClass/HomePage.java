package PageClass;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	//properties
		private RemoteWebDriver driver;
		private WebDriverWait wait;
		@FindBy(how=How.XPATH,using="//input[@id='userName']")
		private WebElement uid;
		@FindBy(how=How.XPATH,using="//input[@id='password']")
		private WebElement pwd;
		@FindBy(how=How.XPATH,using="//div[text()='Wrong username or password!']")
		private WebElement vailcerid;
		@FindBy(how=How.XPATH,using="//button[text()='Login']")
		private WebElement clicksubmit;
		@FindBy(how=How.LINK_TEXT,using="Add Student")
		private WebElement nextpage;
	    //Constructor
		public HomePage(RemoteWebDriver driver,WebDriverWait wait)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
			this.wait=wait;
		}
		//Operational methods
		public void validuerid(String x)
		{
			wait.until(ExpectedConditions.visibilityOf(uid)).sendKeys(x);
		}
		public void validpwd(String x)
		{
			wait.until(ExpectedConditions.visibilityOf(pwd)).sendKeys(x);;
		}
		public boolean isBlankusiderr()
		{
			try
			{
				driver.findElement(By.xpath("//input[@type='submit']")).submit();
				Robot r=new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				return(true);
			}
			catch(Exception ex)
			{
				return(false);
			}
		}
		public boolean invalidcretira()
		{
			try
			{
				wait.until(ExpectedConditions.visibilityOf(vailcerid));
				return(true);
			}
			catch(Exception ex)
			{
				return(false);
			}
			
		}
		public void clickSubmit()
		{
			wait.until(ExpectedConditions.elementToBeClickable(clicksubmit)).click();
		}
		public boolean isDisplayed()
		{
			try
			{
				wait.until(ExpectedConditions.visibilityOf(nextpage));
				return(true);
			}
			catch(Exception ex)
			{
				return(false);
			}
		}
		
			

}
