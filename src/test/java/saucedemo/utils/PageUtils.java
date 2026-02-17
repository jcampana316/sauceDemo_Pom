package saucedemo.utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageUtils.class);

    // Keys de configuración
    private static final String BASE_URL_KEY = "webdriver.base.url";
    private static final String SERENITY_TIMEOUT_KEY = "serenity.timeout";
    private static final int DEFAULT_SERENITY_TIMEOUT_MS = 10000;

    private PageUtils() {
        throw new IllegalStateException("Utility class");
    }

    /** Obtiene la URL base desde la configuración de Serenity */
    public static String getBaseUrl() {
        return Serenity.environmentVariables()
                .optionalProperty(BASE_URL_KEY)
                .orElseThrow(() -> new IllegalStateException(BASE_URL_KEY + " no está configurado en serenity.conf"));
    }

    /** Obtiene una propiedad del archivo de configuración con un valor por defecto */
    public static String getProperty(String propertyKey, String defaultValue) {
        return Serenity.environmentVariables()
                .optionalProperty(propertyKey)
                .orElse(defaultValue);
    }

    /** Lee un int desde serenity.conf con default y fallback seguro */
    public static int getIntProperty(String propertyKey, int defaultValue) {
        String raw = Serenity.environmentVariables().optionalProperty(propertyKey).orElse(null);
        if (raw == null) return defaultValue;

        try {
            return Integer.parseInt(raw.trim());
        } catch (NumberFormatException e) {
            LOGGER.warn("Propiedad '{}' no es numérica ('{}'). Usando default={}", propertyKey, raw, defaultValue);
            return defaultValue;
        }
    }

    /** Timeout global de Serenity para esperas explícitas (ms) */
    public static int serenityTimeoutMs() {
        return getIntProperty(SERENITY_TIMEOUT_KEY, DEFAULT_SERENITY_TIMEOUT_MS);
    }

    /** Escribe texto en un elemento de forma segura */
    public static void typeInto(WebElementFacade element, String text) {
        LOGGER.debug("Escribiendo '{}' en elemento", maskSensitiveData(text));
        element.waitUntilVisible().clear();
        element.type(text);
    }

    /** Escribe texto sin limpiar */
    public static void appendText(WebElementFacade element, String text) {
        LOGGER.debug("Agregando texto en elemento");
        element.waitUntilVisible().type(text);
    }

    /** Click */
    public static void clickOn(WebElementFacade element) {
        LOGGER.debug("Haciendo clic en elemento");
        element.waitUntilClickable().click();
    }

    /** Click con JavaScript */
    public static void clickWithJavaScript(WebElementFacade element, WebDriver driver) {
        LOGGER.debug("Haciendo clic con JavaScript");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /** Scroll hasta elemento */
    public static void scrollToElement(WebElementFacade element, WebDriver driver) {
        LOGGER.debug("Haciendo scroll al elemento");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});", element);
    }

    /** Selecciona si no está seleccionado (para checkbox/radio). */
    public static void selectIfNotSelected(WebElementFacade element) {
        if (!element.isSelected()) {
            LOGGER.debug("Elemento no seleccionado, haciendo clic");
            clickOn(element);
        } else {
            LOGGER.debug("Elemento ya está seleccionado");
        }
    }

    /** Deselecciona si está seleccionado. */
    public static void deselectIfSelected(WebElementFacade element) {
        if (element.isSelected()) {
            LOGGER.debug("Elemento seleccionado, haciendo clic para deseleccionar");
            clickOn(element);
        } else {
            LOGGER.debug("Elemento ya está deseleccionado");
        }
    }

    /** Obtiene texto de forma segura */
    public static String getTextSafely(WebElementFacade element) {
        try {
            String text = element.waitUntilVisible().getText();
            LOGGER.debug("Texto obtenido del elemento: '{}'", text);
            return text;
        } catch (Exception e) {
            LOGGER.warn("No se pudo obtener el texto del elemento: {}", e.getMessage());
            return "";
        }
    }

    /** Verifica visibilidad sin lanzar error */
    public static boolean isVisible(WebElementFacade element) {
        try {
            boolean visible = element.isVisible();
            LOGGER.debug("Elemento visible: {}", visible);
            return visible;
        } catch (Exception e) {
            LOGGER.debug("Elemento no visible: {}", e.getMessage());
            return false;
        }
    }

    /**
     * Espera a que la página esté completamente cargada usando un timeout máximo (serenity.timeout).
     */
    public static void waitForPageLoad(WebDriver driver) {
        LOGGER.debug("Esperando a que la página esté completamente cargada");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        long timeoutMs = serenityTimeoutMs();
        long start = System.currentTimeMillis();
        long pollMs = 100;

        while (System.currentTimeMillis() - start < timeoutMs) {
            try {
                Object state = js.executeScript("return document.readyState");
                if ("complete".equals(String.valueOf(state))) {
                    LOGGER.debug("Página completamente cargada");
                    return;
                }
                Thread.sleep(pollMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.error("Espera interrumpida", e);
                return;
            } catch (Exception e) {
                // Si por algún motivo JS falla (navegación), seguimos intentando hasta timeout
                LOGGER.debug("Aún no se pudo validar readyState: {}", e.getMessage());
            }
        }

        LOGGER.warn("Timeout esperando carga de página ({} ms). Continuando...", timeoutMs);
    }

    public static void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.error("Espera interrumpida", e);
        }
    }

    /** Enmascara datos sensibles para logging */
    private static String maskSensitiveData(String data) {
        if (data == null) return "null";
        if (data.length() <= 2) return "**";
        if (data.length() <= 6) return data.substring(0, 1) + "****";
        return data.substring(0, 2) + "****";
    }


}
