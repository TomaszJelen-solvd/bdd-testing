package com.solvd.bdd_automation.pages.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductComponent extends AbstractComponent {
    @FindBy(css = "div[class='inventory_item_name ']")
    ExtendedWebElement title;

    @FindBy(css = "div[class='inventory_item_price']")
    ExtendedWebElement price;

    @FindBy(css = "button[class='btn btn_primary btn_small btn_inventory ']")
    ExtendedWebElement  addButton;

    public ProductComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductTitle() {
        return title.getText();
    }

    public void clickAddButton() {
        addButton.click();
    }

    public String getAddButtonText() {
        return addButton.getText();
    }
}
