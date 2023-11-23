package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.utilsweb.ElementOperations;

public class ProductsPage {
    ElementOperations operations = new ElementOperations();

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Products']")
    WebElement productsTitle;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement firstProductAddButton;
    @FindBy(xpath = "//a[@id='item_4_title_link']//div[@class='inventory_item_name ']")
    WebElement firstProductName;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']/preceding-sibling::div[@class='inventory_item_price']")
    WebElement firstProductPrice;
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement firstProductRemoveButton;
    @FindBy(xpath = "//a[@id='item_0_title_link']//div[@class='inventory_item_name ']")
    WebElement secondProductName;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement secondProductAddButton;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']/preceding-sibling::div[@class='inventory_item_price']")
    WebElement secondProductPrice;
    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement secondProductRemoveButton;
    @FindBy(xpath = "//div[@id='shopping_cart_container']//span")
    WebElement shoppingCartCountIcon;
    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    WebElement shoppingCartIcon;
    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public boolean isPageLoaded() {
        return operations.isElementVisible(productsTitle);
    }

    public String getFirstProductName() {
        return operations.getElementText(firstProductName).trim();
    }

    public String getSecondProductName() {
        return operations.getElementText(secondProductName).trim();
    }

    public ProductsPage addFirstProduct() {
        operations.clickButton(firstProductAddButton);
        return this;
    }

    public ProductsPage addSecondProduct() {
        operations.clickButton(secondProductAddButton);
        return this;
    }

    public boolean firstProductRemoveButtonIsVisible() {
        return operations.isElementVisible(firstProductRemoveButton);
    }

    public boolean secondProductRemoveButtonIsVisible() {
        return operations.isElementVisible(secondProductRemoveButton);
    }

    public ProductsPage removeFirstProduct() {
        operations.clickButton(firstProductRemoveButton);
        return this;
    }

    public ProductsPage removeSecondProduct() {
        operations.clickButton(secondProductRemoveButton);
        return this;
    }

    public Double getFirstProductPrice() {
        return Double.valueOf(operations.getElementText(firstProductPrice).replace("$", "").trim());
    }

    public Double getSecondProductPrice() {
        return Double.parseDouble(operations.getElementText(secondProductPrice).replace("$", "").trim());
    }

    public int getNumberOfProductsInShoppingCart() {
        return Integer.parseInt(operations.getElementText(shoppingCartCountIcon).trim());
    }

    public boolean isShoppingCartProductCountVisible() {
        return operations.isElementVisible(shoppingCartCountIcon, 2);
    }

    public void goToShoppingCart() {
        operations.clickButton(shoppingCartIcon);
    }

    public void goToCheckoutPage() {
        operations.clickButton(checkoutButton);
    }
}
