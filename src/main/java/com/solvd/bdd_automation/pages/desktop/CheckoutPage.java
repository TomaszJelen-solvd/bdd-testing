package com.solvd.bdd_automation.pages.desktop;

import com.solvd.bdd_automation.pages.CheckoutPageBase;
import com.solvd.bdd_automation.pages.OverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {

    @FindBy(id = "first-name")
    protected ExtendedWebElement firstNameForm;

    @FindBy(id = "last-name")
    protected ExtendedWebElement lastNameForm;

    @FindBy(id = "postal-code")
    protected ExtendedWebElement postalCodeForm;

    @FindBy(id = "continue")
    protected ExtendedWebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void enterFirstName(String firstName) {
        firstNameForm.type(firstName);
    }

    @Override
    protected void enterLastName(String lastName) {
        lastNameForm.type(lastName);
    }

    @Override
    protected void enterPostalCode(String postalCode) {
        postalCodeForm.type(postalCode);
    }

    @Override
    protected OverviewPageBase clickContinue() {
        continueButton.click();
        return initPage(driver, OverviewPageBase.class);
    }
}
