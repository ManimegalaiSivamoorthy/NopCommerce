package testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = ".//features/Customers.feature",
                glue = "stepDefinition",
                tags="not @sanity",
                dryRun = false,
                monochrome = true,
                plugin = {"pretty", "html: test-output"}
        )
public class TestRun {
}
