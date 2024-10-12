package CucumberRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", //feature files
        glue = {"StepDefinitions"}, //Step Definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"}, //Reports
        monochrome = true // to make it easier to read commands in console
)
public class TestRunner { }
