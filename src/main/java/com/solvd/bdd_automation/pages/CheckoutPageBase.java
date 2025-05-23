package com.solvd.bdd_automation.pages;

import org.openqa.selenium.WebDriver;

public abstract class CheckoutPageBase extends PageBase{
    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }


    protected abstract void enterFirstName(String firstName);

    protected abstract void enterLastName(String lastName);

    protected abstract void enterPostalCode(String postalCode);

    protected abstract OverviewPageBase clickContinue();

    public OverviewPageBase performCheckout(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        return clickContinue();
    }
}
