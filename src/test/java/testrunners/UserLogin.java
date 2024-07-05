package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "FeatureFile/userlogin.feature",
		glue = "stepdefinitions",
		dryRun = false
		//plugin = {"pretty","html:testoutput/reports.html"}
		
)
public class UserLogin {

}
