package web.pagemanagers;

import org.openqa.selenium.WebDriver;
import web.pages.*;

public class SaucePageManager {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ShoppingCartPage shoppingCartPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;
    private MenuBarPage menuBarPage;

    public SaucePageManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? new LoginPage(driver) : loginPage;
    }

    public ProductsPage getProductsPage() {
        return (productsPage == null) ? new ProductsPage(driver) : productsPage;
    }

    public ShoppingCartPage getShoppingCartPage() {return (shoppingCartPage == null) ? new ShoppingCartPage(driver) : shoppingCartPage; }

    public CheckoutPage getCheckoutPage() { return (checkoutPage == null) ? new CheckoutPage(driver) : checkoutPage; }

    public CheckoutOverviewPage getCheckoutOverviewPage() { return (checkoutOverviewPage == null) ? new CheckoutOverviewPage(driver) : checkoutOverviewPage; }

    public CheckoutCompletePage getCheckoutCompletePage() { return (checkoutCompletePage == null) ? new CheckoutCompletePage(driver) : checkoutCompletePage; }

    public MenuBarPage getMenuBarPage() { return (menuBarPage == null) ? new MenuBarPage(driver) : menuBarPage; }
}
