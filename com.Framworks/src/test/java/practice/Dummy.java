package practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Dummy 
{
	//Properties
	@FindBy(how=How.XPATH,using="//button[@aria-label='Close']")
	public WebElement close1;
	
	@FindBy(how=How.XPATH,using="//*[name()='svg']//*[name()='svg']//*[name()='g']//*[name()='circle']")
	public WebElement circle;
	
	@FindBy(how=How.LINK_TEXT,using="Got it!")
	public WebElement close2;
	
	@FindBy(how=How.ID,using="holiday_category_id")
	public WebElement message;
	

	public static void main(String[] args)
	{
		

	}

}
