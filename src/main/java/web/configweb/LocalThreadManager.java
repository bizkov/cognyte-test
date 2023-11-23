package web.configweb;

import org.openqa.selenium.WebDriver;

public class LocalThreadManager {
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    static void setWebDriver(WebDriver driver) {
        webDriverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    static void unload() {
        webDriverThreadLocal.remove();
    }
}
