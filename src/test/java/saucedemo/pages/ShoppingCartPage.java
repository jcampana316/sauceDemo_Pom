package saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import saucedemo.ui.ShoppingCartTargets;
import saucedemo.utils.PageUtils;

public class ShoppingCartPage extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartPage.class);


    public void validateCheckoutButton() {
        LOGGER.info("Validando que el boton checkout este presente");
        if (!$(ShoppingCartTargets.CHECKOUT_BUTTON).isVisible()) {
            throw new AssertionError("El botón de checkout no está visible en la página del carrito de compras.");
        }
    }

    public void initiateCheckout() {
        LOGGER.info("Presiono boton de Checkout");
        PageUtils.clickOn($(ShoppingCartTargets.CHECKOUT_BUTTON));
    }
}
