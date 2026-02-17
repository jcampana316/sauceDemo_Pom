package saucedemo.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import saucedemo.steps.InventoryNavigationSteps;
import saucedemo.steps.ShoppingCartSteps;

public class InventoryStepsDefinitions {

    @Steps
    InventoryNavigationSteps  inventoryNavigation;
    ShoppingCartSteps shoopingCartNavigation;

    @Given("usuario se encuentra en el catalogo")
    public void validateUserInCatalog(){
        inventoryNavigation.shouldSeeInventoryTitle();
    }

    @When("selecciona producto {string} y lo agrega al carrito")
    public void seleccionaProducto(String producto){
        inventoryNavigation.selectProduct(producto);
        inventoryNavigation.clickAddToCartButton();
    }

    @And("accedo al carrito de compras")
    public void seleccionoCarrito(){
        inventoryNavigation.clickCartIcon();
    }

    @Then("deberia ver el boton de checkout")
    public void validateCheckoutButton(){
        shoopingCartNavigation.validateCheckoutButton();
    }


}
