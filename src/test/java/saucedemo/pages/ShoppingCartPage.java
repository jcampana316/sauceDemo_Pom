package saucedemo.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import saucedemo.ui.ShoppingCartTargets;

public class ShoppingCartPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartPage.class);


    public void validateCheckoutButton() {
        LOGGER.info("Validando que el boton checkout este presente");
        if (!$(ShoppingCartTargets.CHECKOUT_BUTTON).isVisible()) {
            throw new AssertionError("El botón de checkout no está visible en la página del carrito de compras.");
        }
    }
}
