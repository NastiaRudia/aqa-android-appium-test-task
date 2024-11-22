package screens.fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.driver.DriverActions.isElementVisible;
import static org.testng.Assert.assertTrue;

public class ReviewsFragment {

    private final By image = By.id("onboardingPictureScreenImage");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(image), "Onboarding Reviews image is not visible");
    }

}
