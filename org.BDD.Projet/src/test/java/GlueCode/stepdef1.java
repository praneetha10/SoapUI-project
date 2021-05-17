package GlueCode;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageclasses.HomePage;

public class stepdef1 
{
	public Shared sh;
	public WebDriverWait wait;
	public HomePage hp;
	
	public stepdef1 (Shared sh)
	{
		this.sh=sh;
	}
	@Given("Launch site using\"(.*)\"$")
	public void method1(String bn) throws Exception 
	{
		sh.driver=sh.tu.OpenBrowser(bn);
		wait=sh.tu.definewait(sh.driver);
		hp=new HomePage(sh.driver,wait);
		//Launch site by using url in properties file
		String url=sh.tu.getValuesInPropertiesFile("url");
		sh.tu.launchSite(url);
	}
	@When("scroll into element")
	public void scroll_into_element() 
	{
		try
		{
			hp.scrollInto();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	    
	}
	@Then("getRow size")
	public void get_row_size()
	{
		hp.getRowCount();
	}

	@Then("getcolumn size(.*)$")
	public void getcolumn_size(int r) 
	{
		hp.getColumnCount(r);
	}

	@Then("getCellValue")
	public void get_cell_value(int r,int c) 
	{
	   hp.getCellValue(r, c);
	}
	@Then("Copy to exel")
	public void copy_to_exel() throws Exception 
	{
	  hp.copyToExcel();
	}
	

}
