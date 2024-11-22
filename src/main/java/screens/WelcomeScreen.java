package screens;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.driver.DriverActions.isElementVisible;
import static base.driver.DriverActions.tap;
import static org.testng.Assert.assertTrue;

public class WelcomeScreen {

    private final By title = By.id("title");
    private final By getStartedButton = By.id("startJobsTypeButton");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(title), "Welcome screen is not opened");
    }

    @Step
    public void tapOnGetStartedButton() {
        tap(getStartedButton);
    }

}
