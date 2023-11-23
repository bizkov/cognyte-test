package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.utilsweb.ElementOperations;

public class ShoppingCartPage {
    private ElementOperations operations = new ElementOperations();
    public ShoppingCartPage(WebDriver driver) { PageFactory.initElements(driver, this); }

    @FindBy(xpath = "//span[text()='Your Cart']")
    WebElement shoppingCartTitle;
    @FindBy(xpath = "//a[@id='item_4_title_link']//div[@class='inventory_item_name']")
    WebElement firstProductName;
    @FindBy(css = "#item_4_title_link ~ div div.inventory_item_price")
    WebElement firstProductPrice;
    @FindBy(xpath = "//a[@id='item_0_title_link']//div[@class='inventory_item_name']")
    WebElement secondProductName;
    @FindBy(css = "#item_0_title_link ~ div div.inventory_item_price")
    WebElement secondProductPrice;

    public boolean isPageLoaded() {
        return operations.isElementVisible(shoppingCartTitle);
    }

    public String getFirstProductName() {
        return operations.getElementText(firstProductName);
    }

    public Double getFirstProductPrice() {
        return Double.valueOf(operations.getElementText(firstProductPrice).replace("$", "").trim());
    }

    public String getSecondProductName() {
        return operations.getElementText(secondProductName);
    }

    public Double getSecondProductPrice() {
        return Double.parseDouble(operations.getElementText(secondProductPrice).replace("$", "").trim());
    }
}
