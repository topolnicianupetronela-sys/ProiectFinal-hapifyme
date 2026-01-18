package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed_scenarios.txt", // Citește lista de teste din fișier
        glue = "stepdefinitions",
        plugin = {"pretty", "html:target/rerun-report.html"}
)
public class FailedTestRunner {
}
