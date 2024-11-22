package co.obrio;

import base.data.Gender;
import base.data.Interests;
import base.data.OptionsValue;
import base.data.RelationshipStatus;
import org.testng.annotations.Test;

public class BaseTest extends BaseFixture {

    private final String location = "Kyiv";
    private final String name = "Anastasiia";

    @Test(description = "Onboarding test")
    public void onboardingTest() {
        welcomeScreen.assertIsOpened();
        welcomeScreen.tapOnGetStartedButton();

        onboardingScreen.questionFragment.assertIsOpened();
        onboardingScreen.assertNextButtonIsDisabled();
        onboardingScreen.questionFragment.tapOnAnswerOption(OptionsValue.FUTURE);
        onboardingScreen.questionFragment.assertAnswerOptionCheckboxIsSelected(OptionsValue.FUTURE);
        onboardingScreen.tapOnNextButton();

        onboardingScreen.successGoalsFragment.assertIsOpened();
        onboardingScreen.tapOnNextButton();

        onboardingScreen.birthChartFragment.assertIsOpened();
        onboardingScreen.tapOnNextButton();

        onboardingScreen.dateOfBirthFragment.assertIsOpened();
        onboardingScreen.checkNumberPickers();
        onboardingScreen.tapOnNextButton();

        onboardingScreen.timeOfBirthFragment.assertIsOpened();
        onboardingScreen.checkNumberPickers();
        onboardingScreen.tapOnNextButton();

        onboardingScreen.placeOfBirthFragment.assertIsOpened();
        onboardingScreen.placeOfBirthFragment.fillPlaceOfBirthField(location);
        onboardingScreen.placeOfBirthFragment.clickOnLocation(location);

        onboardingScreen.palmReadingFragment.assertIsOpened();
        onboardingScreen.tapOnSkipButton();

        onboardingScreen.genderFragment.assertIsOpened();
        onboardingScreen.genderFragment.tapOnGender(Gender.FEMALE);

        onboardingScreen.nameFragment.assertIsOpened();
        onboardingScreen.assertNextButtonIsDisabled();
        onboardingScreen.nameFragment.fillNameInput(name);
        onboardingScreen.tapOnNextButton();

        onboardingScreen.relationshipFragment.assertIsOpened();
        onboardingScreen.relationshipFragment.tapOnStatus(RelationshipStatus.ENGAGED);

        onboardingScreen.interestsFragment.assertIsOpened();
        onboardingScreen.assertNextButtonIsDisabled();
        onboardingScreen.interestsFragment.tapOnInterests(Interests.CAREER);
        onboardingScreen.interestsFragment.tapOnInterests(Interests.LOVE);
        onboardingScreen.interestsFragment.assertInterestIsSelected(Interests.CAREER);
        onboardingScreen.interestsFragment.assertInterestIsSelected(Interests.LOVE);
        onboardingScreen.tapOnNextButton();

        onboardingScreen.motivationFragment.assertStatementIsOpened();
        onboardingScreen.motivationFragment.tapYesButton();
        onboardingScreen.motivationFragment.assertMotivationIsOpened();
        onboardingScreen.tapOnNextButton();

        onboardingScreen.remindersFragment.assertIsOpened();
        onboardingScreen.checkNumberPickers();
        onboardingScreen.tapOnSkipButton();

        onboardingScreen.questionFragment.assertIsOpened();
        onboardingScreen.assertNextButtonIsDisabled();
        onboardingScreen.questionFragment.tapOnAnswerOption(OptionsValue.GOOGLE_PLAY);
        onboardingScreen.questionFragment.assertAnswerOptionCheckboxIsSelected(OptionsValue.GOOGLE_PLAY);
        onboardingScreen.tapOnNextButton();

        onboardingScreen.graphicFragment.assertIsOpened();
        onboardingScreen.tapOnNextButton();

        onboardingScreen.reviewsFragment.assertIsOpened();
        onboardingScreen.tapOnNextButton();

        onboardingScreen.signUpFragment.assertIsOpened();
        onboardingScreen.signUpFragment.tapOnContinueWithEmailButton();

        signUpScreen.assertIsOpened();
    }

}

