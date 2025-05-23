package com.solvd.bdd_automation.pages.desktop;

import com.solvd.bdd_automation.pages.OverviewPageBase;
import com.solvd.bdd_automation.pages.components.CartItemComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = OverviewPageBase.class)
public class OverviewPage extends OverviewPageBase {

    @FindBy(css = "div[class='cart_item']")
    protected List<CartItemComponent> products;

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean checkProductInCart(String productName) {
        for(CartItemComponent component : products) {
            if (component.getItemTitle().equals(productName)) {
                return true;
            }
        }
        return false;
    }
}
