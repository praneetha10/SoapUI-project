package PageClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
	//Properties
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	@FindBy(how=How.XPATH,using="(//button[@class='btn btn-primary btn-lg'])[1]")
	private WebElement loginclick;
	@FindBy(how=How.XPATH,using="//select[@name='userSelect']")
	private WebElement dd;
	
	
	//Constructor 
	public LoginPage(RemoteWebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=wait;
	} 
	//Operationl methods
	public void clickCust()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loginclick)).click();
	}
	public List<String>dropDrown() throws Exception
	{
		Select s=new Select(dd);
		List<WebElement>e=s.getOptions();
		List<String> actual=new ArrayList<String>();
		for(WebElement ss:e)
		{
			Thread.sleep(1000);
			ss.click();
			actual.add(ss.getText());
		}
		return actual;
	}
}
