package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"pretty",
                "rerun:target/failedScenarios.txt",
                "html:target/reports/html-reports/default-cucumber-reports.html",
                "json:target/reports/json-reports/cucumber1.json"
        },
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@kampanyalar",
        dryRun = false

)
public class Runner {
}
