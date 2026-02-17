package saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import saucedemo.ui.ProductTargets;
import saucedemo.utils.PageUtils;

public class ProductPage extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPage.class);

    public void clickAddToCartButton() {
        LOGGER.info("Agregando producto al carrito");
        PageUtils.clickOn($(ProductTargets.ADD_TO_CART_BUTTON));
        PageUtils.clickOn($(ProductTargets.BACK_TO_PRODUCTS_LINK));
    }


}
