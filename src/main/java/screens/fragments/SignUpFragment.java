package screens.fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.driver.DriverActions.isElementVisible;
import static base.driver.DriverActions.tap;
import static org.testng.Assert.assertTrue;

public class SignUpFragment {

    private final By title = By.id("onboardingSignupTitleText");
    private final By authGoogleButton = By.id("authGoogleButton");
    private final By authEmailButton = By.id("authEmailButton");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(title), "Onboarding Goals Graphic title is not visible");
    }

    @Step
    public void tapOnContinueWithEmailButton() {
        tap(authEmailButton);
    }

}
