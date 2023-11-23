package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.utilsweb.ElementOperations;

public class CheckoutPage {
    private ElementOperations operations = new ElementOperations();
    public CheckoutPage(WebDriver driver) { PageFactory.initElements(driver, this); }

    @FindBy(xpath = "//span[text()='Checkout: Your Information']")
    WebElement checkoutTitle;
    @FindBy(id = "first-name")
    WebElement firstNameField;
    @FindBy(id = "last-name")
    WebElement lastNameField;
    @FindBy(id = "postal-code")
    WebElement zipCodeField;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    public boolean isPageLoaded() {
        return operations.isElementVisible(checkoutTitle);
    }

    public void checkout() {
        operations.clickButton(continueButton);
    }

    public String getErrorMessage() {
        return operations.getElementText(errorMessage).trim();
    }

    public CheckoutPage enterFirstName(String firstName) {
        operations.fillInput(firstNameField, firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        operations.fillInput(lastNameField, lastName);
        return this;
    }

    public void enterZipCode(String zipCode) {
        operations.fillInput(zipCodeField, zipCode);
    }

    public CheckoutPage clearFirstNameField() {
        operations.clearField(firstNameField);
        return this;
    }

    public CheckoutPage clearLastNameField() {
        operations.clearField(lastNameField);
        return this;
    }

    public void clearZipCodeField() {
        operations.clearField(zipCodeField);
    }
}
