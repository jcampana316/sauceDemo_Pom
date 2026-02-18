package saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import saucedemo.ui.CheckOutTargets;
import saucedemo.utils.PageUtils;

public class CheckOutPage extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckOutPage.class);

    public void ingresarInformacionCliente(String nombre, String apellido, String codigoPostal) {
        LOGGER.info("Ingresando información del cliente: Nombre={}, Apellido={}, Código Postal={}", nombre, apellido, codigoPostal);
        PageUtils.typeInto($(CheckOutTargets.FIRST_NAME_INPUT),nombre);
        PageUtils.typeInto($(CheckOutTargets.LAST_NAME_INPUT),apellido);
        PageUtils.typeInto($(CheckOutTargets.ZIP_CODE_INPUT),codigoPostal);
        PageUtils.clickOn($(CheckOutTargets.CONTINUE_BUTTON));

    }
}
