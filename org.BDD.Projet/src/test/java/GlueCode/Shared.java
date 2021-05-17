package GlueCode;

import org.openqa.selenium.remote.RemoteWebDriver;

import Utilities.Testutility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Shared 
{
	//Globl object related to all step definittion classes
	public RemoteWebDriver driver;
	public Scenario s;
	public Testutility  tu;
	
	@Before
	public void method1(Scenario s)
	{
		driver=null;
		this.s=s;
		tu=new Testutility();
	}
	@After 
	public void method2(Scenario s)
	{
		s.log(s.getName()+"is completed");
	}
}
