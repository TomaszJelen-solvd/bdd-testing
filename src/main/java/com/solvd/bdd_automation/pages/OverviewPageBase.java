package com.solvd.bdd_automation.pages;

import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class OverviewPageBase extends PageBase {
    public OverviewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean checkProductInCart(String productName);

    public boolean checkProductsInCart(List<String> productNames) {
        for (String productName : productNames) {
            if (!this.checkProductInCart(productName)) {
                return false;
            }
        }
        return true;
    }
}
