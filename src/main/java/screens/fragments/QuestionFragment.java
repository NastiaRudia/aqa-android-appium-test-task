package screens.fragments;

import base.data.OptionsValue;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static base.driver.DriverActions.findVisibleElements;
import static base.driver.DriverActions.isElementVisible;
import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertTrue;

public class QuestionFragment {

    private final By title = By.id("onboardingQuestionTitleText");
    private final By answersOptions = By.id("optionRoot");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(title), "Onboarding Social screen is not opened");
    }

    @Step
    public void tapOnAnswerOption(OptionsValue option) {
        Option goalOption = getAnswerOptions().stream()
                .filter(el -> el.getOptionText().equals(option.getValue()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(option.getValue() + " option was not found"));
        goalOption.tapOnOption();
    }

    @Step
    public void assertAnswerOptionCheckboxIsSelected(OptionsValue option) {
        assertTrue(getAnswerOptions().stream()
                        .anyMatch(el -> el.getOptionText().equals(option.getValue()) && el.isCheckboxSelected()),
                "Goal checkbox is not selected");
    }

    private List<Option> getAnswerOptions() {
        return findVisibleElements(answersOptions).stream()
                .map(Option::new)
                .collect(toList());
    }

}
