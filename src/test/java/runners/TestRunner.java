package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Calea către fișierele feature (folderul resources)
        features = "src/test/resources/features",

        // Pachetul unde se află clasele Java cu @Given, @When (glue code)
        glue = "stepdefinitions",

        // Plugin-uri pentru rapoarte (în consolă și HTML)
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "rerun:target/failed_scenarios.txt" // Aici se va genera lista cu teste picate
        },

        // Face output-ul din consolă mai ușor de citit
        monochrome = true
)
public class TestRunner {
    // Această clasă rămâne goală!
    // Ea servește doar ca suport pentru adnotări.
}


