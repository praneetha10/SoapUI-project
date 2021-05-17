package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComposePage
{
	RemoteWebDriver driver;
	WebDriverWait wait;
	@FindBy(how=How.NAME,using="//div[text()='Compose']")
	private WebElement cmp;
	@FindBy(how=How.NAME,using="to")
	private WebElement sendto;
	@FindBy(how=How.NAME,using="subjectbox")
	private WebElement subjectmsg;
	@FindBy(how=How.XPATH,using="//div[@aria-label='Message Body']")
	private WebElement msgbody;
	@FindBy(how=How.XPATH,using="//div[@aria-label='Attach files']")
	private WebElement attach;
	@FindBy(how=How.NAME,using="//div[contains(@aria-label,'Attachment:')] ")
	private WebElement uploaded; 
	@FindBy(how=How.XPATH,using="//div[text()='Send']")
	private WebElement send;
	@FindBy(how=How.XPATH,using="//span[text()='Message sent.']")
	private WebElement outputmsg;
	//Constructor Method
	 public ComposePage(RemoteWebDriver driver2, WebDriverWait wait2)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 this.wait=wait;
	 }
	 //Operational Methods
	 public boolean isComposevisiable()
	 {
		 try
		 {
			 wait.until(ExpectedConditions.visibilityOf(cmp));
			 return(true);
		 }
		 catch(Exception ex)
		 {
			 return(false);
			 
		 }
	 }
	 public void clickCompose()
	 {
		 wait.until(ExpectedConditions.visibilityOf(cmp)).click();
	 }
	 public void fillTo(String x)
	 {
		 wait.until(ExpectedConditions.visibilityOf(sendto)).sendKeys(x);
	 }
	 public void fillSubject(String x)
	 {
		 wait.until(ExpectedConditions.visibilityOf(subjectmsg)).sendKeys(x);
	 }
	 public void fillBody(String x)
	 {
		 wait.until(ExpectedConditions.visibilityOf(msgbody)).sendKeys(x);
	 }
	 public void attachment(String x)throws Exception
	 {
		 wait.until(ExpectedConditions.invisibilityOf(attach));
		 attach.sendKeys(x);
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
		 catch(Exception ex)
		 {
			 return("sorry mail didnot send");
		 }
	 }
}
