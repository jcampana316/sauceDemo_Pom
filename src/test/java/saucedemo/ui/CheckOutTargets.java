package saucedemo.ui;

import org.openqa.selenium.By;

public class CheckOutTargets {

    private CheckOutTargets(){}

    public static final By FIRST_NAME_INPUT = By.xpath("//*[contains(@id, 'first-name')]");
    public static final By LAST_NAME_INPUT = By.xpath("//*[contains(@id, 'last-name')]");
    public static final By ZIP_CODE_INPUT = By.xpath("//*[contains(@id, 'postal-code')]");
    public static final By CONTINUE_BUTTON = By.xpath("//*[contains(@id, 'continue')]");
    public static final By CANCEL_BUTTON = By.xpath("//*[contains(@id, 'cancel')]");


}
