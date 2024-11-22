package screens.fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import static base.driver.DriverActions.*;
import static org.testng.Assert.assertEquals;

public class NumberPicker {

    private final WebElement root;
    private final By input = By.xpath("//android.widget.EditText");
    private final By buttons = By.xpath("//android.widget.Button");

    public NumberPicker(WebElement root) {
        this.root = root;
    }

    @Step
    public void setNextValue() {
        WebElement topButton = getFirstButton();
        Point topButtonLocation = topButton.getLocation();
        Point inputLocation = getInput().getLocation();
        String expectedValue = topButton.getText();
        performMoveSequence(topButtonLocation.x, topButtonLocation.y, inputLocation.x, inputLocation.y);
        checkInputText(expectedValue);
    }

    @Step
    public void checkInputText(String text) {
        assertEquals(getInput().getText(), text);
    }

    @Step
    public WebElement getInput() {
        return findVisibleElement(root, input);
    }

    @Step
    public WebElement getFirstButton() {
        return findVisibleElements(root, buttons).get(0);
    }
}
