package com.solvd.bdd_automation.cucumber.steps;

import com.solvd.bdd_automation.pages.*;
import com.zebrunner.carina.cucumber.CucumberRunner;
import com.zebrunner.carina.webdriver.IDriverPool;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class MyStepsDefinitions extends CucumberRunner implements IDriverPool {

    LoginPageBase loginPage;

    InventoryPageBase inventoryPage;

    CartPageBase cartPage;

    CheckoutPageBase checkoutPage;

    OverviewPageBase overviewPageBase;

    List<String> products = List.of("Sauce Labs Bike Light", "Sauce Labs Onesie");

    @Given("I am on login page")
    public void iAmOnLoginPage() {
        loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
    }

    @When("I perform login")
    public void iPerformLogin() {
        //In future replaced with data from database
        inventoryPage = loginPage.performLogin("standard_user", "secret_sauce");
    }


    @And("I add products to cart from list")
    public void iAddProductsToCartFromList() {
        //In future replaced with data from database
        inventoryPage.addProductsToCart(products);
    }

    @And("I enter cart")
    public void iEnterCart() {
        cartPage = inventoryPage.clickCart();
    }

    @And("I checkout cart")
    public void iCheckoutCart() {
        checkoutPage = cartPage.clickCheckout();
    }

    @And("I perform checkout")
    public void iPerformCheckout() {
        //In future replaced with data from database
        overviewPageBase = checkoutPage.performCheckout("Test", "First", "123");
    }

    @Then("All products form list are in overview")
    public void allProductsFormListAreInOverview() {
        //In future replaced with data from database
        Assert.assertTrue(overviewPageBase.checkProductsInCart(products), "Failed to find all required products in overview");
    }
}

