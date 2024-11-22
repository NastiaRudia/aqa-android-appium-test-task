package screens.fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static base.driver.DriverActions.*;

public class Option {

    private final WebElement root;
    private final By text = By.id("optionTitle");
    private final By checkbox = By.id("optionRadiobutton");

    public Option(WebElement root) {
        this.root = root;
    }

    @Step
    public String getOptionText() {
        return getText(root, text);
    }

    @Step
    public void tapOnOption() {
        tap(root);
    }

    @Step
    public boolean isCheckboxSelected() {
        return isElementSelected(root, checkbox);
    }

}
