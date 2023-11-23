package stepdefinitions.websteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.pagemanagers.SaucePageManager;

import static org.testng.Assert.*;
import static web.configweb.LocalThreadManager.getDriver;

public class SauceStepDefs {
    SaucePageManager saucePageManager = new SaucePageManager(getDriver());
    String firstProductName = "";
    String secondProductName = "";
    Double firstProductPrice = 0.0;
    Double secondProductPrice = 0.0;
    Double finalAmount = 0.0;

    @Given("User is logged with standard_user")
    public void login() {
        assertTrue(saucePageManager.getLoginPage().isPageLoaded());
        saucePageManager.getLoginPage().login();
        assertTrue(saucePageManager.getProductsPage().isPageLoaded());
    }


    @When("User add the first two products to shopping cart")
    public void userAddTheFirstTwoProductsToBasket() {
        firstProductName = saucePageManager.getProductsPage().getFirstProductName();
        firstProductPrice = saucePageManager.getProductsPage().getFirstProductPrice();
        secondProductName = saucePageManager.getProductsPage().getSecondProductName();
        secondProductPrice = saucePageManager.getProductsPage().getSecondProductPrice();
        finalAmount = firstProductPrice + secondProductPrice;
        saucePageManager.getProductsPage()
                .addFirstProduct()
                .addSecondProduct();
    }

    @Then("Two products are added")
    public void theProductsAreAdded() {
        assertTrue(saucePageManager.getProductsPage().firstProductRemoveButtonIsVisible());
        assertTrue(saucePageManager.getProductsPage().secondProductRemoveButtonIsVisible());
        assertEquals(saucePageManager.getProductsPage().getNumberOfProductsInShoppingCart(), 2);
    }

    @When("User remove the products")
    public void userRemoveTheProducts() {
        saucePageManager.getProductsPage()
                .removeFirstProduct()
                .removeSecondProduct();
    }

    @Then("The shopping cart is empty")
    public void theShoppingCartIsEmpty() {
        assertFalse(saucePageManager.getProductsPage().isShoppingCartProductCountVisible());
    }

    @When("User go to the shopping cart")
    public void userGoToTheShoppingCart() {
        saucePageManager.getProductsPage().goToShoppingCart();
        assertTrue(saucePageManager.getShoppingCartPage().isPageLoaded());
    }

    @Then("The products are displayed properly")
    public void theProductsAreDisplayedProperly() {
        assertEquals(saucePageManager.getShoppingCartPage().getFirstProductName(), firstProductName);
        assertEquals(saucePageManager.getShoppingCartPage().getFirstProductPrice(), firstProductPrice);
        assertEquals(saucePageManager.getShoppingCartPage().getSecondProductName(), secondProductName);
        assertEquals(saucePageManager.getShoppingCartPage().getSecondProductPrice(), secondProductPrice);
    }

    @Then("User go to checkout page")
    public void userGoToCheckoutPage() {
        saucePageManager.getProductsPage().goToCheckoutPage();
        assertTrue(saucePageManager.getCheckoutPage().isPageLoaded());
    }

    @And("Validate field errors")
    public void validateFieldErrors() {
        saucePageManager.getCheckoutPage().checkout();
        assertEquals(saucePageManager.getCheckoutPage().getErrorMessage(), "Error: First Name is required");
        saucePageManager.getCheckoutPage().enterFirstName("First");
        saucePageManager.getCheckoutPage().checkout();
        assertEquals(saucePageManager.getCheckoutPage().getErrorMessage(), "Error: Last Name is required");
        saucePageManager.getCheckoutPage().enterLastName("Last");
        saucePageManager.getCheckoutPage().checkout();
        assertEquals(saucePageManager.getCheckoutPage().getErrorMessage(), "Error: Postal Code is required");
    }

    @Then("Clear all fields")
    public void clearAllFields() {
        saucePageManager.getCheckoutPage()
                .clearFirstNameField()
                .clearLastNameField()
                .clearZipCodeField();
    }

    @And("Fill the form and checkout")
    public void fillTheFormAndCheckout() {
        saucePageManager.getCheckoutPage()
                .enterFirstName("First")
                .enterLastName("Last")
                .enterZipCode("1234");
        saucePageManager.getCheckoutPage().checkout();
    }

    @Then("Verify the preview information")
    public void verifyThePreviewInformation() {
        assertTrue(saucePageManager.getCheckoutOverviewPage().isPageLoaded());
        assertEquals(saucePageManager.getCheckoutOverviewPage().getFirstProductName(), firstProductName);
        assertEquals(saucePageManager.getCheckoutOverviewPage().getFirstProductPrice(), firstProductPrice);
        assertEquals(saucePageManager.getCheckoutOverviewPage().getSecondProductName(), secondProductName);
        assertEquals(saucePageManager.getCheckoutOverviewPage().getSecondProductPrice(), secondProductPrice);
        assertEquals(saucePageManager.getCheckoutOverviewPage().getItemTotal(), finalAmount);
        assertEquals(saucePageManager.getCheckoutOverviewPage().getTotal(),
                (finalAmount + saucePageManager.getCheckoutOverviewPage().getTax()));
    }

    @Then("Verify the successful message")
    public void verifyTheSuccessfulMessage() {
        saucePageManager.getCheckoutOverviewPage().finishOrder();
        assertTrue(saucePageManager.getCheckoutCompletePage().isPageLoaded());
        assertEquals(saucePageManager.getCheckoutCompletePage().getMessage(), "Thank you for your order!");
    }

    @And("logout")
    public void logout() throws InterruptedException {
        saucePageManager.getMenuBarPage()
                .goToMenu()
                .logout();
        assertTrue(saucePageManager.getLoginPage().isPageLoaded());
    }
}
