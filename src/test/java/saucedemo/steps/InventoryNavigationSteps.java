package saucedemo.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.assertj.core.api.Assertions;
import saucedemo.pages.InventoryPage;
import saucedemo.pages.ProductPage;

public class InventoryNavigationSteps extends UIInteractionSteps {

    InventoryPage inventoryPage;
    ProductPage productPage;

    @Step("Validar que la cuenta fue creada correctamente")
    public void shouldSeeInventoryTitle() {
        Assertions.assertThat(inventoryPage.isLoginSuccessful())
                .as("El header del menu debe ser Products")
                .isTrue();
    }

    public void clickMenuIcon() {
        inventoryPage.clickMenuIcon();
    }

    public void clickLogoutLink() {
        inventoryPage.logout();
    }

    public void selectProduct(String productName) {
        inventoryPage.selectProduct(productName);
    }

    public void clickAddToCartButton(){
        productPage.clickAddToCartButton();
    }


    public void clickCartIcon() {
        inventoryPage.clickCartIcon();
    }
}
