package saucedemo.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import saucedemo.pages.ShoppingCartPage;

public class ShoppingCartSteps  extends UIInteractionSteps {

    ShoppingCartPage shoppingCartPage;

    @Step("Valida boton checkout")
    public void validateCheckoutButton() {
        shoppingCartPage.validateCheckoutButton();
    }
}
