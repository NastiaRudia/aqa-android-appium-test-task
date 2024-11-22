package base;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static base.driver.DriverActions.findVisibleElements;
import static base.driver.DriverActions.tap;

public class TestUtils {

    private TestUtils() {
    }

    @Step
    public static void tapOnOptionByText(By locator, String value) {
        WebElement matchingElement = findVisibleElements(locator).stream()
                .filter(element -> element.getText().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(value + " was not found"));
        tap(matchingElement);
    }
}
