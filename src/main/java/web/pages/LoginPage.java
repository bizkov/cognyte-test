package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.utilsweb.ElementOperations;
import static web.utilsweb.UIConstants.*;

public class LoginPage {
    private ElementOperations operations = new ElementOperations();
    public LoginPage(WebDriver driver) { PageFactory.initElements(driver, this); }

    @FindBy(id = "user-name")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public boolean isPageLoaded() {
        return operations.isElementVisible(loginButton);
    }

    public void login() {
        operations.fillInput(userName, USER_EMAIL);
        operations.fillInput(password, USER_PASSWORD);
        operations.clickButton(loginButton);
    }
}
