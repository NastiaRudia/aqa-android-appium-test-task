package screens.fragments;

import base.data.Interests;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.TestUtils.tapOnOptionByText;
import static base.driver.DriverActions.findVisibleElements;
import static base.driver.DriverActions.isElementVisible;
import static org.testng.Assert.assertTrue;

public class InterestsFragment {

    private final By title = By.id("onboardingInterestsTitleText");
    private final By interests = By.id("name");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(title), "Onboarding Place of Birth screen is not opened");
    }

    @Step
    public void tapOnInterests(Interests interest) {
        tapOnOptionByText(interests, interest.getValue());
    }

    @Step
    public void assertInterestIsSelected(Interests interest) {
        assertTrue(findVisibleElements(interests).stream()
                        .anyMatch(webElement -> webElement.getText().equals(interest.getValue()) && webElement.isSelected()),
                interest + "Interest should be selected");
    }

}
