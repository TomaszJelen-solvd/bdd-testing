package com.solvd.bdd_automation.pages.desktop;

import com.solvd.bdd_automation.pages.CartPageBase;
import com.solvd.bdd_automation.pages.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(id = "checkout")
    protected ExtendedWebElement checkout;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutPageBase clickCheckout() {
        checkout.click();
        return initPage(driver, CheckoutPageBase.class);
    }
}
