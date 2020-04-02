package testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = ".//features/login.feature",
                glue = "stepDefinition",
                dryRun = false,
                plugin = {"pretty", "html: test-output"}
        )
public class TestRun {
}
