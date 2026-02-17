package saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webelements.RadioButtonGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import saucedemo.ui.InventoryTargets;
import saucedemo.utils.PageUtils;

public class InventoryPage extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);


    public boolean isLoginSuccessful() {
        return PageUtils.isVisible($(InventoryTargets.INVENTORY_TITLE));
    }

    public void clickMenuIcon() {
        PageUtils.clickOn($(InventoryTargets.MENU_ICON));
    }

    public void logout() {
        PageUtils.clickOn($(InventoryTargets.LOGOUT_LINK));
    }

    public void selectProduct(String productName) {
        String itemXpath = InventoryTargets.ITEM.toString().replace("productName", productName);
        PageUtils.clickOn($(itemXpath));
    }

    public void clickCartIcon() {
        PageUtils.clickOn($(InventoryTargets.SHOPPING_CART_ICON));
    }
}
