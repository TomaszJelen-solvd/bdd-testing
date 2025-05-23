package com.solvd.bdd_automation.pages.desktop;

import com.solvd.bdd_automation.pages.CartPageBase;
import com.solvd.bdd_automation.pages.InventoryPageBase;
import com.solvd.bdd_automation.pages.components.ProductComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = InventoryPageBase.class)
public class InventoryPage extends InventoryPageBase {

    @FindBy(xpath = "//div[text()='Swag Labs']")
    protected ExtendedWebElement title;

    @FindBy(css = "a[class='shopping_cart_link']")
    protected ExtendedWebElement cart;

    @FindBy(css = "div[class='inventory_item']")
    protected List<ProductComponent> products;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPageBase clickCart() {
        cart.click();
        return initPage(driver, CartPageBase.class);
    }

    @Override
    public void addProductToCart(String productName) {
        for(ProductComponent component : products) {
            if (component.getProductTitle().equals(productName)) {
                component.clickAddButton();
                break;
            }
        }
    }
}
