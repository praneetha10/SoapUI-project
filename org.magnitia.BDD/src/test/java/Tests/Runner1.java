package Tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={"src\\test\\resources\\features"},
		glue= {"GlueCode"},
		monochrome=true,
		plugin= {"pretty","html:target\\smoketestres","rerun:target\\failedsmoketestscenarios.txt"}
		)
public class Runner1 extends AbstractTestNGCucumberTests
{
}
