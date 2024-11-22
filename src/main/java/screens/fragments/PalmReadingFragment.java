package screens.fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.driver.DriverActions.isElementVisible;
import static base.driver.DriverActions.tap;
import static org.testng.Assert.assertTrue;

public class PalmReadingFragment {

    private final By title = By.id("onboardingPalmistryTitleText");
    private final By scanButton = By.id("onboardingPalmistryScanButton");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(title), "Onboarding Palm reading screen is not opened");
    }

    @Step
    public void tapScanButton() {
        tap(scanButton);
    }
}
