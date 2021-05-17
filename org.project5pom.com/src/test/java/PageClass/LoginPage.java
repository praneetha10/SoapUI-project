package PageClass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	//Proprties 
		private RemoteWebDriver driver;
		private WebDriverWait wait;
		@FindBy(how=How.LINK_TEXT,using="Add Student")
		private WebElement nextpage;
		@FindBy(how=How.XPATH,using="//input[@name='name']")
		private WebElement textbox;
		@FindBy(how=How.XPATH,using="//select[@id='class'and @name='class']")
		private WebElement dropdown;
		@FindBy(how=How.XPATH,using="//input[@id='roll-number']")
		private WebElement rollno;
		@FindBy(how=How.XPATH,using="//input[@type='radio' and @name='gender'")
		private WebElement radio;
		@FindBy(how=How.XPATH,using="//input[@type='submit']")
		private WebElement clicksubmit;
		@FindBy(how=How.XPATH,using="//select[@id='class']")
		private WebElement dd_class;
		
		//Constructor
		public LoginPage(RemoteWebDriver driver,WebDriverWait wait)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
			this.wait=wait;
		}
		//Operational method
		public void nextPage()
		{
			wait.until(ExpectedConditions.elementToBeClickable(nextpage)).click();
		}
		public void username(String x)
		{
			wait.until(ExpectedConditions.visibilityOf(textbox)).sendKeys(x);;
		}
		public List<String> dropDown() throws Exception
		{
			Select s=new Select(dd_class);
			List<WebElement>e=s.getOptions();
			List<String>actualContents=new ArrayList<String>();
			for(WebElement e1:e)
			{
				try
				{
					actualContents.add(e1.getText());
					
				}
				catch(Exception ex)
				{
					ex.getMessage();
				}
				
			}
			return(actualContents);
		}
		public void rollnum(String num)
		{
			wait.until(ExpectedConditions.visibilityOf(rollno)).sendKeys(num);
		}
		public void radiobutton() throws Exception
		{
			
			radio.click();
		}
			
		public void method1() throws Exception
		{
			driver.findElement(By.xpath("//input[@type='submit']")).submit();
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}

}
