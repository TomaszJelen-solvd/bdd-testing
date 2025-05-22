package com.solvd.bdd_automation.pages;

import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class InventoryPageBase extends PageBase {

    public InventoryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase clickCart();

    public abstract void addProductToCart(String productName);

    public void addProductsToCart(List<String> productNames) {
        for (String productName : productNames) {
            addProductToCart(productName);
        }
    }
}
