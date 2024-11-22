package screens;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import screens.fragments.*;

import static base.driver.DriverActions.*;
import static org.testng.Assert.assertFalse;

public class OnboardingScreen {

    private final By nextButton = By.id("primaryButton");
    private final By skipButton = By.id("onboardingSkipButton");
    private final By numberPickers = AppiumBy.className("android.widget.NumberPicker");

    public QuestionFragment questionFragment = new QuestionFragment();
    public SuccessGoalsFragment successGoalsFragment = new SuccessGoalsFragment();
    public BirthChartFragment birthChartFragment = new BirthChartFragment();
    public DateOfBirthFragment dateOfBirthFragment = new DateOfBirthFragment();
    public TimeOfBirthFragment timeOfBirthFragment = new TimeOfBirthFragment();
    public PlaceOfBirthFragment placeOfBirthFragment = new PlaceOfBirthFragment();
    public PalmReadingFragment palmReadingFragment = new PalmReadingFragment();
    public GenderFragment genderFragment = new GenderFragment();
    public NameFragment nameFragment = new NameFragment();
    public RelationshipFragment relationshipFragment = new RelationshipFragment();
    public InterestsFragment interestsFragment = new InterestsFragment();
    public MotivationFragment motivationFragment = new MotivationFragment();
    public RemindersFragment remindersFragment = new RemindersFragment();
    public GraphicFragment graphicFragment = new GraphicFragment();
    public ReviewsFragment reviewsFragment = new ReviewsFragment();
    public SignUpFragment signUpFragment = new SignUpFragment();

    @Step
    public void tapOnNextButton() {
        tap(nextButton);
    }

    @Step
    public void tapOnSkipButton() {
        tap(skipButton);
    }

    @Step
    public void assertNextButtonIsDisabled() {
        assertFalse(isElementEnabled(nextButton), "Next button was enabled");
    }

    @Step
    public void checkNumberPickers() {
        findVisibleElements(numberPickers).stream()
                .map(NumberPicker::new)
                .forEach(NumberPicker::setNextValue);
    }

}
