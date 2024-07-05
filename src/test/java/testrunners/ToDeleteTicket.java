package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "FeatureFile/todeleteticket.feature",
		glue = "stepdefinitions",
		dryRun = false
		//plugin = {"pretty","html:testoutput/reports.html"}
		
)
public class ToDeleteTicket {

}
