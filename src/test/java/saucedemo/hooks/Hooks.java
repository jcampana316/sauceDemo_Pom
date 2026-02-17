package saucedemo.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hooks {

    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario) {
        LOGGER.info("========================================");
        LOGGER.info("Ejecutando escenario: {}", scenario.getName());
        LOGGER.info("========================================");
    }
}
