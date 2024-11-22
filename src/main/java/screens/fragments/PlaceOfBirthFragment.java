package screens.fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static base.driver.DriverActions.*;
import static org.testng.Assert.assertTrue;

public class PlaceOfBirthFragment {

    private final By description = By.id("onboardingBirthPlaceDescriptionText");
    private final By placeInput = By.id("onboardingBirthPlaceEditText");
    private final By locations = By.id("primary_text");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(description), "Onboarding Place of Birth screen is not opened");
    }

    @Step
    public void fillPlaceOfBirthField(String placeOfBirth) {
        type(placeInput, placeOfBirth);
    }

    @Step
    public void clickOnLocation(String placeOfBirth) {
        WebElement location = findVisibleElements(locations).stream()
                .filter(webElement -> webElement.getText().equals(placeOfBirth))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(placeOfBirth + " location was not found"));
        location.click();
    }

}
