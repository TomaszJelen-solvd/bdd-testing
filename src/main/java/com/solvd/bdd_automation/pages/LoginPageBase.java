package com.solvd.bdd_automation.pages;

import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends PageBase {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    protected abstract void enterLogin(String login);

    protected abstract void enterPassword(String password);

    protected abstract InventoryPageBase clickLogin();

    public InventoryPageBase performLogin(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        return clickLogin();
    }


}
