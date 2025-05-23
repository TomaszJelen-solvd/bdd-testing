package com.solvd.bdd_automation.pages.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItemComponent extends AbstractComponent {

    @FindBy(css = "div[class='inventory_item_name']")
    ExtendedWebElement title;

    public CartItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getItemTitle() {
        return title.getText();
    }
}
