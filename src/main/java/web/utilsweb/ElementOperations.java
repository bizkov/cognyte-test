package web.utilsweb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.fail;
import static web.configweb.LocalThreadManager.getDriver;

public class ElementOperations {

    public void clickButton(WebElement element) {
        WebDriverManager.chromedriver().setup();
        waitElementToBeClickable(element);
        element.click();
    }

    public void fillInput(WebElement element, String text) {
        waitElementToBeClickable(element);
        element.clear();
        element.sendKeys(text);
    }

    public void clearField(WebElement element) {
        element.clear();
    }

    private void waitElementToBeClickable(WebElement element) {
        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
        } catch (StaleElementReferenceException e) {
            fail("Element is not clickable");
        }
    }

    public void waitElementToBeVisible(WebElement element) {
        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
        } catch (StaleElementReferenceException e) {
            fail("Element is not clickable");
        }
    }

    public void waitElementToBeVisible(WebElement element, int seconds) {
        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));
        } catch (StaleElementReferenceException e) {
            fail("Element is not clickable");
        }
    }

    public String getElementText(WebElement element) {
        waitElementToBeVisible(element);
        return element.getText();
    }

    public boolean isElementVisible(WebElement element) {
        try {
            waitElementToBeVisible(element);
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementVisible(WebElement element, int seconds) {
        try {
            waitElementToBeVisible(element, seconds);
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
