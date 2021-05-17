package Tests;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		features= {"src\\test\\resources\\features"},
		glue= {"GlueCode"},
		monochrome=true,
		plugin= {"pretty","html:target\\realtestres","rerun:target\\realtestfailedres.txt"}
		)
public class Runner2 {

}
