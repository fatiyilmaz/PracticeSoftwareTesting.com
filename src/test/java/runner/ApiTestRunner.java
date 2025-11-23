package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = {"stepdefinitions", "runner"},
        plugin = {
                "pretty",
                "json:target/cucumber-reports/api-report.json",
                "html:target/cucumber-reports/api-report.html"
        },
        monochrome = true,
        tags = "@contactMessages"
)
public class ApiTestRunner extends AbstractTestNGCucumberTests {

    // Paralel senaryo çalıştırmayı mümkün kılar
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
