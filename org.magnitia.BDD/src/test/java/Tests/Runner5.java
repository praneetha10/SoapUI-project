package Tests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src\\test\\resources\\features"},
		glue= {"GlueCode"},
		tags="@soketest",
		monochrome=true,
		plugin= {"pretty","html:target\\smoketestres","rerun:target\\failedsmoketestscenarios.txt"}
		)
public class Runner5 {

}
