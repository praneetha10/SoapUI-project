package GlueCode;

import org.openqa.selenium.remote.RemoteWebDriver;

import Utilityclasses.TestUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Shared
{
	public RemoteWebDriver driver;
	public Scenario s; //To Generate HTML Reports in Scenario wise
	public TestUtility tu;
	
	//Method to be executed before for every "Scenario:" or "Scenario Outline:" iteration
	@Before
	public void method1(Scenario s)throws Exception
	{
		//define driver object as null by default
		driver=null;
		//create "scenario"class object to work for current "scenario:" or "Scenario outline:"
		this.s=s;
		//create object to TestUtility class
		tu=new TestUtility();
	}
	@After
	public void method2(Scenario s)
	{
		s.log(s.getName()+"is completed");
	}
}
