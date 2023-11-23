package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.utilsweb.ElementOperations;

public class CheckoutOverviewPage {
    private ElementOperations operations = new ElementOperations();
    public CheckoutOverviewPage(WebDriver driver) { PageFactory.initElements(driver, this); }

    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    WebElement checkoutOverviewTitle;
    @FindBy(xpath = "//a[@id='item_4_title_link']//div[@class='inventory_item_name']")
    WebElement firstProductName;
    @FindBy(css = "#item_4_title_link ~ div div.inventory_item_price")
    WebElement firstProductPrice;
    @FindBy(xpath = "//a[@id='item_0_title_link']//div[@class='inventory_item_name']")
    WebElement secondProductName;
    @FindBy(css = "#item_0_title_link ~ div div.inventory_item_price")
    WebElement secondProductPrice;
    @FindBy(css = ".summary_subtotal_label")
    WebElement itemsTotal;
    @FindBy(css = ".summary_tax_label")
    WebElement tax;
    @FindBy(css = ".summary_total_label")
    WebElement total;
    @FindBy(id = "finish")
    WebElement finishButton;

    public boolean isPageLoaded() {
        return operations.isElementVisible(checkoutOverviewTitle);
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

    public Double getItemTotal() {
        return Double.parseDouble(operations.getElementText(itemsTotal).replace("Item total: $", "").trim());
    }

    public Double getTax() {
        return Double.parseDouble(operations.getElementText(tax).replace("Tax: $", "").trim());
    }

    public Double getTotal() {
        return Double.parseDouble(operations.getElementText(total).replace("Total: $", "").trim());
    }

    public void finishOrder() {
        operations.clickButton(finishButton);
    }
}
