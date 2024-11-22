package screens.fragments;

import base.data.Gender;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.TestUtils.tapOnOptionByText;
import static base.driver.DriverActions.isElementVisible;
import static org.testng.Assert.assertTrue;

public class GenderFragment {

    private final By title = By.id("onboardingGenderTitleText");
    private final By genders = By.id("answerSquareButtonTitle");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(title), "Onboarding Place of Birth screen is not opened");
    }

    @Step
    public void tapOnGender(Gender gender) {
        tapOnOptionByText(genders, gender.getValue());
    }

}
