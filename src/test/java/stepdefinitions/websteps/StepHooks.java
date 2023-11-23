package stepdefinitions.websteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import web.configweb.BrowserManager;

import java.io.File;
import java.time.LocalDateTime;

import static web.configweb.LocalThreadManager.getDriver;
import static web.utilsweb.UIConstants.*;

public class StepHooks {
    BrowserManager browserManager = new BrowserManager();


    @Before
    public void beforeScenario() {
        browserManager.browserDriver().createDriverInstance(CHROME_BROWSER);
        getDriver().navigate().to("https://www.saucedemo.com/");
    }

    @After
    public void afterWebScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) getDriver();
            final byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", (scenario.getName() + File.separator + LocalDateTime.now()));
        }
        browserManager.browserDriver().closeDriver();
    }
}
