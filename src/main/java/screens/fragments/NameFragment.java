package screens.fragments;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.driver.DriverActions.isElementVisible;
import static base.driver.DriverActions.type;
import static org.testng.Assert.assertTrue;

public class NameFragment {

    private final By nameImage = By.id("onboardingNameImage");
    private final By nameInput = AppiumBy.className("android.widget.EditText");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(nameImage), "Onboarding Time of Birth screen is not opened");
    }

    @Step
    public void fillNameInput(String name) {
        type(nameInput, name);
    }

}
