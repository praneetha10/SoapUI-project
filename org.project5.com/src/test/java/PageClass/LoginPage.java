package PageClass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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
		public void dropDown() throws Exception
		{
			
			WebElement e=driver.findElement(By.xpath("//select[@id='class']"));
			Select s=new Select(e);
			List<WebElement>items=s.getOptions();
			for(WebElement item:items)
			{
				String x=item.getText();
				System.out.println(x);
				Thread.sleep(1000);
				item.click();
			}
		}
		public void rollnum(String num)
		{
			wait.until(ExpectedConditions.visibilityOf(rollno)).sendKeys(num);
		}
		public void radiobutton() throws Exception
		{
			List<WebElement> e=driver.findElements(By.xpath("//input[@type='radio' and @name='gender']"));
			System.out.println("count of items in drop down"+ e.size());
			
		}
			
		public void method1() throws Exception
		{
			driver.findElement(By.xpath("//input[@type='submit']")).submit();
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}

}
