package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComposePage 
{
	//Properties
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	@FindBy(how=How.XPATH,using="//div[text()='Compose']")
	private WebElement comp;
	@FindBy(how=How.NAME,using="to")
	private WebElement toaddress;
	@FindBy(how=How.NAME,using="subjectbox")
	private WebElement subject;
	@FindBy(how=How.XPATH,using="//div[@aria-label='Message Body']")
	private WebElement body;
	@FindBy(how=How.XPATH,using="//input[@type='file'and@name='Filedata']")
	private WebElement attach;
	@FindBy(how=How.XPATH,using="//div[contains(@aria-label,'Uploading')]")
	private WebElement uploading;
	@FindBy(how=How.NAME,using="//div[contains(@aria-label,'Attachment:')] ")
	private WebElement uploaded; 
	@FindBy(how=How.XPATH,using="(//div[contains(@aria-label,'Send ')])[2]")
	private WebElement send;
	@FindBy(how=How.XPATH,using="//span[text()='Message sent.']")
	private WebElement outputmessage;
	//Constructor method
	public ComposePage (RemoteWebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=wait;
	}
	//Operational methods to Operate elements
	public boolean isComposeVisible()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(comp));
			return(true);
		}
		catch(Exception ex)
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
	public void attachment(String x)throws Exception
	{
		wait.until(ExpectedConditions.invisibilityOf(attach));
		attach.sendKeys(x);
		wait.until(ExpectedConditions.visibilityOf(uploading));
		wait.until(ExpectedConditions.visibilityOf(uploaded));
	}
	public void clickSend()
	{
		wait.until(ExpectedConditions.elementToBeClickable(send)).click();
	}
	
	public String getoutputMessage()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(outputmessage));
			return(outputmessage.getText());
		}
		catch(Exception ex)
		{
			return("sorry mail is not sent");
		}
	}
}
