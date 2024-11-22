package screens.fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.driver.DriverActions.isElementVisible;
import static base.driver.DriverActions.tap;
import static org.testng.Assert.assertTrue;

public class MotivationFragment {

    private final By statementTitleText = By.id("onboardingStatementTitleText");
    private final By noButton = By.id("onboardingStatementNoButton");
    private final By yesButton = By.id("onboardingStatementYesButton");
    private final By motivationTitle = By.id("onboardingMotivationTitleText");

    @Step
    public void assertStatementIsOpened() {
        assertTrue(isElementVisible(statementTitleText), "Onboarding Palm reading screen is not opened");
    }

    @Step
    public void assertMotivationIsOpened() {
        assertTrue(isElementVisible(motivationTitle), "Onboarding Palm reading screen is not opened");
    }

    @Step
    public void tapNoButton() {
        tap(noButton);
    }

    @Step
    public void tapYesButton() {
        tap(yesButton);
    }
}
