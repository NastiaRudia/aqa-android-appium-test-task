package base.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.function.Supplier;

import static base.driver.Driver.getDriver;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public final class DriverActions {

    private static final Logger logger = LoggerFactory.getLogger(DriverActions.class);
    private static final long DEFAULT_WAIT = 30L;
    private static final int RETRY_COUNT = 3;

    private static WebDriverWait getDefaultWait() {
        return new WebDriverWait(getDriver(), ofSeconds(DEFAULT_WAIT));
    }

    public static WebElement findVisibleElement(By locator) {
        logger.info("Finding visible element by locator: {}", locator);
        return retryOnStaleElement(() -> getDefaultWait().until(visibilityOfElementLocated(locator)));
    }

    public static WebElement findVisibleElement(WebElement rootElement, By childLocator) {
        return findVisibleElements(rootElement, childLocator).get(0);
    }

    public static List<WebElement> findVisibleElements(WebElement rootElement, By childLocator) {
        logger.info("Finding visible child elements by locator: {} under root element", childLocator);
        return retryOnStaleElement(() ->
                getDefaultWait().until(visibilityOfNestedElementsLocatedBy(rootElement, childLocator))
        );
    }

    public static List<WebElement> findVisibleElements(By locator) {
        logger.info("Finding visible elements by locator: {}", locator);
        return retryOnStaleElement(() ->
                getDefaultWait().until(visibilityOfAllElementsLocatedBy(locator))
        );
    }

    public static boolean isElementVisible(By locator) {
        try {
            logger.info("Checking visibility of element by locator: {}", locator);
            return findVisibleElement(locator) != null;
        } catch (TimeoutException e) {
            logger.error("Element by locator {} is not visible: {}", locator, e.getMessage());
            return false;
        }
    }

    public static boolean isElementSelected(WebElement rootElement, By childLocator) {
        try {
            logger.info("Checking if child element is selected by locator: {} under root element", childLocator);
            return findVisibleElement(rootElement, childLocator).isSelected();
        } catch (TimeoutException e) {
            logger.error("Failed to check if element is selected: {}", e.getMessage());
            return false;
        }
    }

    public static boolean isElementEnabled(By locator) {
        try {
            logger.info("Checking if element is disabled by locator: {}", locator);
            return findVisibleElement(locator).isEnabled();
        } catch (TimeoutException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public static void tap(By locator) {
        logger.info("Tapping on element by locator: {}", locator);
        WebElement element = retryOnStaleElement(() ->
                getDefaultWait().until(ExpectedConditions.elementToBeClickable(locator))
        );
        element.click();
    }

    public static void tap(WebElement element) {
        logger.info("Tapping on provided element");
        retryOnStaleElement(() -> {
            getDefaultWait().until(ExpectedConditions.elementToBeClickable(element)).click();
            return null;
        });
    }

    public static void type(By locator, String text) {
        logger.info("Typing text '{}' into element by locator: {}", text, locator);
        WebElement element = findVisibleElement(locator);
        element.clear();
        element.sendKeys(text);
        getDefaultWait().until(or(
                textToBePresentInElementValue(locator, text),
                textToBePresentInElementLocated(locator, text)
        ));
    }

    public static String getText(By locator) {
        logger.info("Getting text from element by locator: {}", locator);
        return findVisibleElement(locator).getText();
    }

    public static String getText(WebElement rootElement, By childLocator) {
        logger.info("Getting text from child element by locator: {} under root element", childLocator);
        return findVisibleElement(rootElement, childLocator).getText();
    }

    public static void performMoveSequence(int startX, int startY, int endX, int endY) {
        logger.info("Perform moving sequence");
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence chain = new Sequence(finger, 1);
        chain.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        chain.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        chain.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), endX, endY));
        chain.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getDriver().perform(List.of(chain));
    }

    private static <T> T retryOnStaleElement(Supplier<T> action) {
        for (int attempt = 1; attempt <= RETRY_COUNT; attempt++) {
            try {
                return action.get();
            } catch (StaleElementReferenceException e) {
                logger.warn("StaleElementReferenceException caught. Retrying attempt {}/{}", attempt, RETRY_COUNT);
            }
        }
        throw new RuntimeException("Failed to resolve StaleElementReferenceException after " + RETRY_COUNT + " attempts.");
    }
}
