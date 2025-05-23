package com.solvd.bdd_automation.cucumber.steps;

import com.solvd.bdd_automation.myBatis.dao.MyBatisDaoUser;
import com.solvd.bdd_automation.myBatis.dao.MyBatisDaoUserOrderItem;
import com.solvd.bdd_automation.myBatis.model.User;
import com.solvd.bdd_automation.myBatis.model.UserOrderItem;
import com.solvd.bdd_automation.myBatis.service.UserService;
import com.solvd.bdd_automation.pages.*;
import com.zebrunner.carina.cucumber.CucumberRunner;
import com.zebrunner.carina.webdriver.IDriverPool;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class MyStepsDefinitions extends CucumberRunner implements IDriverPool {

    LoginPageBase loginPage;

    InventoryPageBase inventoryPage;

    CartPageBase cartPage;

    CheckoutPageBase checkoutPage;

    OverviewPageBase overviewPageBase;

    List<String> products;

    User user;

    @Given("I have {int} user data")
    public void iHaveUserData(int id) throws SQLException, InterruptedException {
        MyBatisDaoUser daoUser = new MyBatisDaoUser();
        MyBatisDaoUserOrderItem daoUserOrderItem = new MyBatisDaoUserOrderItem();
        UserService userService = new UserService(daoUser, daoUserOrderItem);
        user = userService.readUser((long) id);
        products = user.getUserOrder().stream().map(UserOrderItem::getProductName).collect(Collectors.toList());
    }

    @And("I am on login page")
    public void iAmOnLoginPage() {
        loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
    }

    @When("I perform login")
    public void iPerformLogin() {
        inventoryPage = loginPage.performLogin("standard_user", "secret_sauce");
    }


    @And("I add products to cart from list")
    public void iAddProductsToCartFromList() {
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
        overviewPageBase = checkoutPage.performCheckout(user.getName(), user.getSurname(), user.getPostalCode());//"Test", "First", "123");
    }

    @Then("All products form list are in overview")
    public void allProductsFormListAreInOverview() {
        Assert.assertTrue(overviewPageBase.checkProductsInCart(products), "Failed to find all required products in overview");
    }


}

