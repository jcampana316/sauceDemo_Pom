package saucedemo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import saucedemo.steps.InventoryNavigationSteps;
import saucedemo.steps.LoginNavigationSteps;

public class LoginStepsDefinitions {
    @Steps
    LoginNavigationSteps navigation;
    InventoryNavigationSteps inventoryNavigation;

    @Given("el usuario se encuentra en la pagina de login")
    public void openLoginSauce() {
        navigation.openLoginSauce();
    }

    // Acepta tanto: el usuario ingresa su usuario "<user>" y contraseña "<password>" validos
    // como: el usuario ingresa su usuario <user> y contraseña <password> validos
    @When("el usuario ingresa su usuario {string} y contraseña {string} validos")
    public void typeUserData(String user, String password)
    {
        navigation.typeUserData(user, password);
    }

    @Then("el usuario es redirigido al catalogo")
    public void shouldSeeCatalog() {
        inventoryNavigation.shouldSeeInventoryTitle();
    }

    @Given("el usuario se encuentra en la pagina de catalogo")
    public void openInventory() {
        inventoryNavigation.shouldSeeInventoryTitle();
    }

    @When("el usuario hace click en el boton de menu y selecciona logout")
    public void logout() {
        inventoryNavigation.clickMenuIcon();
        inventoryNavigation.clickLogoutLink();
    }

    @Then ("el usuario es redirigido a la pagina de login")
    public void shouldSeeLogin() {
        navigation.shouldRedirectToLogin();
    }

}
