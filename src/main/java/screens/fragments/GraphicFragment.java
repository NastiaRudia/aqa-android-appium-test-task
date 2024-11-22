package screens.fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.driver.DriverActions.isElementVisible;
import static org.testng.Assert.assertTrue;

public class GraphicFragment {

    private final By animation = By.id("onboardingGoalsGraphicAnimate");
    private final By title = By.id("onboardingGoalsGraphicTitleText");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(animation), "Onboarding Goals Graphic animation is not visible");
        assertTrue(isElementVisible(title), "Onboarding Goals Graphic title is not visible");
    }

}
