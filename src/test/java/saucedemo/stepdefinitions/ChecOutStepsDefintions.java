package saucedemo.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import saucedemo.steps.CheckOutNavigationSteps;

public class ChecOutStepsDefintions {

    CheckOutNavigationSteps checkOutNavigation;

    @And("ingreso la informacion del cliente")
    public void ingresoLaInformacionDelCliente(DataTable datos) {
        checkOutNavigation.ingresarInformacionCliente(datos);
    }

    @And("finalizo la compra")
    public void finalizoLaCompra() {
        checkOutNavigation.finalizarCompra();
    }
}
