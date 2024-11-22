package screens.fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.driver.DriverActions.isElementVisible;
import static org.testng.Assert.assertTrue;

public class RemindersFragment {

    private final By animation = By.id("onboardingDailyPushAnimation");
    private final By pushTimePicker = By.id("onboardingDailyPushTimePicker");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(animation), "Animation on Onboarding Reminders screen is not visible");
        assertTrue(isElementVisible(pushTimePicker), "Push time picker on Onboarding Reminders screen is not visible");

    }

}
