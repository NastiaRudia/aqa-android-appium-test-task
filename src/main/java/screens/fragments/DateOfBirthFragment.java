package screens.fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.driver.DriverActions.isElementVisible;
import static org.testng.Assert.assertTrue;

public class DateOfBirthFragment {

    private final By image = By.id("onboardingBirthDateImage");
    private final By birthDatePicker = By.id("onboardingBirthDatePicker");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(image), "Image on Onboarding Date of Birth screen is not visible");
        assertTrue(isElementVisible(birthDatePicker), "Date picker on Onboarding Date of Birth screen is not visible");
    }
}
