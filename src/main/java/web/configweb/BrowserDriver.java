package web.configweb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static web.configweb.LocalThreadManager.*;

public class BrowserDriver {
    private static final Logger LOGGER = LogManager.getLogger(BrowserDriver.class);

    public void createDriverInstance(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            setWebDriver(new ChromeDriver());
            getDriver().manage().window().maximize();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            setWebDriver(new FirefoxDriver());
            getDriver().manage().window().fullscreen();

        } else {
            LOGGER.info("Your Browser is not supported. The supported browser parameters are: chrome, firefox");
        }
    }

    public void createDriverInstance(String browserName, String option) {

        if ((browserName == null) || (browserName.equalsIgnoreCase("chrome"))) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(option);
            setWebDriver(new ChromeDriver(options));
            getDriver().manage().window().maximize();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(option);
            setWebDriver(new FirefoxDriver(options));
            getDriver().manage().window().fullscreen();
        } else {
            LOGGER.error("Your Browser is not supported. The supported browser parameters are: chrome, firefox");
        }
    }

    public void closeDriver() {
        getDriver().quit();
        unload();
    }
}
