package practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Dummy1
{
	@FindBy(how=How.XPATH,using="//h4[text()='Search Selection']")
	public WebElement scroll;
	
	

	public static void main(String[] args)
	{
		

	}

}
