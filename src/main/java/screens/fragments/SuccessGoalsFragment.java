package screens.fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.driver.DriverActions.isElementVisible;
import static org.testng.Assert.assertTrue;

public class SuccessGoalsFragment {

    private final By title = By.id("onboardingGoalsPersonalTitleText");
    private final By image = By.id("lottie");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(title), "Success Goals screen title is not visible");
        assertTrue(isElementVisible(image), "Success Goals screen image is not visible");
    }

}
