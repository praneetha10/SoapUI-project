package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComposePage
{
	//Properties for locating elements
	private RemoteWebDriver driver;
	private WebDriverWait wait;
			
	@FindBy(how=How.XPATH,using="//*[text()='Compose']")
	private WebElement comp;
			
	@FindBy(how=How.NAME,using="to")
	private WebElement toaddress;
			
	@FindBy(how=How.NAME,using="subjectbox")
	private WebElement subject;
	
	@FindBy(how=How.XPATH,using="//div[@aria-label='Message Body']")
	private WebElement body;
	
	@FindBy(how=How.XPATH,using="//input[@name='Filedata' and @type='file']")
	private WebElement attach;
	
	@FindBy(how=How.XPATH,using="//*[contains(@aria-label,'Attachment:')]")
	private WebElement uploaded;
			
	@FindBy(how=How.XPATH,using="//*[text()='Send']")
	private WebElement send;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Message sent')]")
	private WebElement outputmsg;
	
	
	//Constructor method for connecting runner classes(via Association)
	public ComposePage(RemoteWebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=wait;
	}
			
	//Operational methods to operate elements
	public boolean isComposeVisible()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(comp));
			return(true);
		}
		catch(TimeoutException ex)
		{
			return(false);
		}
	}
	
	public void clickCompose()
	{
		wait.until(ExpectedConditions.visibilityOf(comp)).click();
	}
	
	public void fillTo(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(toaddress)).sendKeys(x);
	}
	
	public void fillSubject(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(subject)).sendKeys(x);
	}
	
	public void fillBody(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(body)).sendKeys(x);
	}
	
	public void attachment(String x) throws Exception
	{
		//element to locator
		String p[]=attach.toString().split(":");
		p[2]=p[2].substring(0, p[2].length()-1);
		p[2]=p[2].trim();
		By b=By.xpath(p[2]);
		wait.until(ExpectedConditions.presenceOfElementLocated(b)).sendKeys(x);
		wait.until(ExpectedConditions.visibilityOf(uploaded));
	}
	
	public void clickSend()
	{
		wait.until(ExpectedConditions.elementToBeClickable(send)).click();
	}
	
	public String getOutputMessage()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(outputmsg));
			return(outputmsg.getText());
		}
		catch(TimeoutException ex)
		{
			return("Sorry, Mail did not send");
		}
	}
}

