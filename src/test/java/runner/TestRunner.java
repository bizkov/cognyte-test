package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/features"},
        tags = "@Sauce",
        glue = "stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-html-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                }
)
public class TestRunner extends AbstractTestNGCucumberTests {
    public TestRunner() {
    }
}
