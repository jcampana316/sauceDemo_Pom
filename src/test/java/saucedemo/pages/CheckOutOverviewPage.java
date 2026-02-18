package saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import saucedemo.ui.CheckOutOverviewTargets;
import saucedemo.utils.PageUtils;

public class CheckOutOverviewPage extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckOutOverviewPage.class);

    public void finalizarCompra() {
        LOGGER.info("Finaliza compra");
        PageUtils.scrollToElement($(CheckOutOverviewTargets.FINISH_BUTTON), getDriver());
        if(PageUtils.isVisible($(CheckOutOverviewTargets.FINISH_BUTTON))) {
            LOGGER.info("Botón 'Finish' es visible, procediendo a hacer click");
            PageUtils.clickOn($(CheckOutOverviewTargets.FINISH_BUTTON));
        } else {
            LOGGER.warn("Botón 'Finish' no es visible, no se podrá finalizar la compra");
        }
    }
}
