package screens.fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.driver.DriverActions.isElementVisible;
import static org.testng.Assert.assertTrue;

public class TimeOfBirthFragment {

    private final By animation = By.id("onboardingBirthTimeAnimation");
    private final By birthTimePicker = By.id("onboardingBirthTimePicker");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(animation), "Animation on Onboarding Time of Birth screen is not visible");
        assertTrue(isElementVisible(birthTimePicker), "Time picker on Onboarding Time of Birth screen is not visible");
    }

}
