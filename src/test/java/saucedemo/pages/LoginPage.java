package saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import saucedemo.ui.LoginTargets;
import saucedemo.utils.PageUtils;

public class LoginPage extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    public void openHomePage() {
        String url = PageUtils.getBaseUrl();
        LOGGER.info("Abriendo página principal de SauceDemo: {}", url);
        openUrl(url);
        PageUtils.waitForPageLoad(getDriver());
    }

    public void typeUserDataAndClickLogin(String user, String password) {
        LOGGER.info("Ingresando usuario: {} y contraseña: {}", user, password);
        PageUtils.typeInto($(LoginTargets.USER_NAME), user);
        PageUtils.typeInto($(LoginTargets.PASSWORD), password);
        PageUtils.clickOn($(LoginTargets.LOGIN_BUTTON));
    }

    public boolean isLoginRedirectSuccesful() {
        LOGGER.info("Redirigiendo usuario a página de inventario");
        return PageUtils.isVisible($(LoginTargets.USER_NAME));
    }
}
