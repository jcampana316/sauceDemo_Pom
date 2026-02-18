package saucedemo.steps;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.UIInteractionSteps;
import saucedemo.pages.CheckOutOverviewPage;
import saucedemo.pages.CheckOutPage;

public class CheckOutNavigationSteps extends UIInteractionSteps {

    CheckOutPage checkOutPage;
    CheckOutOverviewPage checkOutOverviewPage;

    public void ingresarInformacionCliente(DataTable datos) {
        String nombre = datos.cell(1,0);
        String apellido = datos.cell(1,1);
        String codigoPostal = datos.cell(1,2);
        checkOutPage.ingresarInformacionCliente(nombre, apellido, codigoPostal);
    }


    public void finalizarCompra() {
        checkOutOverviewPage.finalizarCompra();
    }
}
