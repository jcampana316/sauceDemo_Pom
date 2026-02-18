package saucedemo.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.assertj.core.api.Assertions;
import saucedemo.pages.InventoryPage;
import saucedemo.pages.LoginPage;

@Slf4j
public class LoginNavigationSteps extends UIInteractionSteps {

    LoginPage loginPage;
    InventoryPage inventoryPage;


    @Step("Abrir pagina SauceDemo")
    public void openLoginSauce(){
        loginPage.openHomePage();
    }


    @Step("Ingresar usuario {0} y contraseña {1} y click login")
    public void typeUserData(String user, String password) {
        loginPage.typeUserDataAndClickLogin(user, password);
    }


    @Step("Validar que la cuenta fue creada correctamente")
    public void shouldSeeInventoryTitle() {
        Assertions.assertThat(inventoryPage.isLoginSuccessful())
                .as("El header del menu debe ser Products")
                .isTrue();
    }

    @Step("Validar retorno a Login , deberia ver user y password")
    public void shouldRedirectToLogin() {

        Assertions.assertThat(loginPage.isLoginRedirectSuccesful())
                        .as("Se regreso al Login").isTrue();
    }

    public void ingresarCredenciales(DataTable datos) throws Throwable {
        String user = datos.cell(1,0);
        String password = datos.cell(1,1);
        typeUserData(user,password);
    }
}
