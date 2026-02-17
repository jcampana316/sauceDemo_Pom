package saucedemo.ui;

import org.openqa.selenium.By;

public class ProductTargets {

    private ProductTargets(){}

    //detailed product
    public static final By PRODUCT_TITLE = By.xpath("//*[contains(@class, 'inventory_details_name large_size')]");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//*[contains(@id, 'add-to-cart')]");
    public static final By BACK_TO_PRODUCTS_LINK = By.xpath("//*[contains(@id, 'back-to-products')]");

}
