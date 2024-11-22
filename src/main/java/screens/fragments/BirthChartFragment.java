package screens.fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.driver.DriverActions.isElementVisible;
import static org.testng.Assert.assertTrue;

public class BirthChartFragment {

    private final By animation = By.id("onboardingMotivationAnimation");
    private final By title = By.id("onboardingMotivationTitleText");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(animation), "Onboarding Birth Chart animation is not visible");
        assertTrue(isElementVisible(title), "Onboarding Birth Chart title is not visible");
    }

}
