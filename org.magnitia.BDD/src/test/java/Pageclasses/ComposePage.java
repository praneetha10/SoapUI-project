package Pageclasses;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComposePage 
{
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	@FindBy(how=How.XPATH,using="//div[text()='Compose']")
	private WebElement cmp;
	@FindBy(how=How.NAME,using="to")
	private WebElement sendto;
	@FindBy(how=How.NAME,using="subjectbox")
	private WebElement subject;
	@FindBy(how=How.XPATH,using="//div[@aria-label='Message Body']")
	private WebElement msgbody;
	@FindBy(how=How.XPATH,using="//input[@type='file' and @name='Filedata']")
	private WebElement attach;
	@FindBy(how=How.XPATH,using="//div[contains(@aria-label,'Attachment:')]")
	private WebElement uploaded;
	@FindBy(how=How.XPATH,using="//div[contains(@aria-label,'Send')and @role='button']")
	private WebElement send;
	@FindBy(how=How.XPATH,using="//span[text()='Message sent.']")
	private WebElement outputmsg;
	@FindBy(how=How.XPATH,using="//div[text()='Compose']")
	private WebElement displaycmp;
	//Constructor method
	public ComposePage(RemoteWebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait=wait;
	}
	//Operational method
	public boolean isComposeVisiable()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(displaycmp));
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
		
	}
	public void isCompose()
	{
		wait.until(ExpectedConditions.elementToBeClickable(cmp)).click();
	}
	public void fillTo(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(sendto)).sendKeys(x);
	}
	public void fillSubject(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(subject)).sendKeys(x);
	}
	public void fillBody(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(msgbody)).sendKeys(x);
	}
	public void attachFile(String x) throws Exception
	{
		wait.until(ExpectedConditions.invisibilityOf(attach));
		attach.sendKeys(x);
		wait.until(ExpectedConditions.visibilityOf(uploaded));
	}
	public void sendMsg()
	{
		wait.until(ExpectedConditions.elementToBeClickable(send)).click();
	}
	public String getOutputmsg()
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(outputmsg));
			return(outputmsg.getText());
		}
		catch(Exception ex)
		{
			return("sorry mail is not sent");
		}
		
	}
	
}
