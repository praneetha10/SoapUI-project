package PageClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class openaccount 
{
	//properties
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Open Account')]")
	private WebElement openact;
	@FindBy(how=How.ID,using="userSelect")
	private WebElement custName;
	@FindBy(how=How.NAME,using="userSelect")
	private WebElement dropdown;
	@FindBy(how=How.XPATH,using="//select[@name='currency']")
	private WebElement currencydd;
	@FindBy(how=How.XPATH,using="//button[text()='Process']")
	private WebElement process;
	
	//Constructor method
	public openaccount(RemoteWebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=wait;
	}
	//Operational methods
	public void linkOpenaccount()
	{
		wait.until(ExpectedConditions.elementToBeClickable(openact)).click();
	}
	public void customer()
	{
		wait.until(ExpectedConditions.elementToBeClickable(custName)).click();
	}
	
	public List<String> dropDrown() throws Exception
	{
		Select s=new Select(dropdown);
		List<WebElement>e=s.getOptions();
		List<String> actual=new ArrayList<String>();
		for(WebElement e2:e)
		{
			actual.add(e2.getText());
			
		}
		return actual;
	}
	public List<String> Currency() throws Exception
	{
		Select s=new Select(currencydd);
		List<WebElement>e1=s.getOptions();
		e1.size();
		List<String>actual1=new ArrayList<String>();
		for(WebElement e2:e1)
		{
			Thread.sleep(5000);
			e2.click();
			actual1.add(e2.getText());
		}
		return actual1;
	}
}
