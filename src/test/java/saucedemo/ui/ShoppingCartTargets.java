package saucedemo.ui;

import org.openqa.selenium.By;

public class ShoppingCartTargets {

    private ShoppingCartTargets(){}

    public static final By CHECKOUT_BUTTON = By.xpath("//*[contains(@class, 'shopping_cart_badge')]");
}
