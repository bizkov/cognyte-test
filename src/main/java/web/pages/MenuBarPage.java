package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.utilsweb.ElementOperations;

public class MenuBarPage {

    private ElementOperations operations = new ElementOperations();
    public MenuBarPage(WebDriver driver) { PageFactory.initElements(driver, this); }

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;
    @FindBy(id = "logout_sidebar_link")
    WebElement logout;

    public MenuBarPage goToMenu() {
        operations.clickButton(menuButton);
        return this;
    }

    public void logout() {
        operations.clickButton(logout);
    }
}
