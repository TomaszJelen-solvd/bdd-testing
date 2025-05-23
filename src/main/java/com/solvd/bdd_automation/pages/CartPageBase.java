package com.solvd.bdd_automation.pages;

import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends PageBase {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CheckoutPageBase clickCheckout();
}
