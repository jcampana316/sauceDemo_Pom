package saucedemo.ui;

import org.openqa.selenium.By;

public class InventoryTargets {
    private InventoryTargets(){}

    public static final By INVENTORY_TITLE = By.xpath("//*[contains(@class, 'title')]");
    public static final By MENU_ICON = By.xpath("//*[contains(@id, 'react-burger-menu-btn')]");
    public static final By LOGOUT_LINK = By.xpath("//*[contains(@id, 'logout_sidebar_link')]");

    public static final By ITEM = By.xpath("//*[contains(text(), 'productName')]");
    public static final By SHOPPING_CART_ICON = By.xpath("//*[contains(@class, 'shopping_cart_badge')]");


}
