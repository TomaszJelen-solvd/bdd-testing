package com.solvd.bdd_automation.pages.desktop;

import com.solvd.bdd_automation.pages.InventoryPageBase;
import com.solvd.bdd_automation.pages.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(id = "user-name")
    protected ExtendedWebElement loginNameForm;

    @FindBy(id = "password")
    protected ExtendedWebElement loginPasswordForm;

    @FindBy(id = "login-button")
    protected ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void enterLogin(String login) {
        loginNameForm.type(login);
    }

    @Override
    protected void enterPassword(String password) {
        loginPasswordForm.type(password);
    }

    @Override
    protected InventoryPageBase clickLogin() {
        loginButton.click();
        return initPage(driver, InventoryPageBase.class);
    }
}
