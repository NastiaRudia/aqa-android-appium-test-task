package screens.fragments;

import base.data.RelationshipStatus;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.TestUtils.tapOnOptionByText;
import static base.driver.DriverActions.isElementVisible;
import static org.testng.Assert.assertTrue;

public class RelationshipFragment {

    private final By title = By.id("onboardingRelationshipTitleText");
    private final By relationshipStatuses = By.id("answerSquareButtonTitle");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(title), "Onboarding Place of Birth screen is not opened");
    }

    @Step
    public void tapOnStatus(RelationshipStatus relationshipStatus) {
        tapOnOptionByText(relationshipStatuses, relationshipStatus.getValue());
    }

}
