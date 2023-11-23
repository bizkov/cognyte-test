package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.utilsweb.ElementOperations;

public class CheckoutCompletePage {
    private ElementOperations operations = new ElementOperations();
    public CheckoutCompletePage(WebDriver driver) { PageFactory.initElements(driver, this); }

    @FindBy(xpath = "//span[text()='Checkout: Complete!']")
    WebElement checkoutCompleteTitle;
    @FindBy(xpath = "//div[@id='checkout_complete_container']//h2[@class='complete-header']")
    WebElement successfulMessage;
    @FindBy(id = "back-to-products")
    WebElement backToHomeButton;

    public boolean isPageLoaded() {
        return operations.isElementVisible(checkoutCompleteTitle);
    }

    public String getMessage() {
        return operations.getElementText(successfulMessage);
    }

    public void backToHome() {
        operations.clickButton(backToHomeButton);
    }
}
