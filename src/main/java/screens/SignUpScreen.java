package screens;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.driver.DriverActions.isElementVisible;
import static base.driver.DriverActions.tap;
import static org.testng.Assert.assertTrue;

public class SignUpScreen {

    private final By emailInput = By.xpath("//android.widget.TextView[@text=\"Email\"]/following-sibling::android.widget.EditText");
    private final By passwordInput = By.xpath("//android.widget.TextView[@text=\"Password\"]/following-sibling::android.widget.EditText");
    private final By confirmPasswordInput = By.xpath("//android.widget.TextView[@text=\"Confirm password\"]/following-sibling::android.widget.EditText");

    @Step
    public void assertIsOpened() {
        assertTrue(isElementVisible(emailInput), "Email field is not visible on Sign Up Screen");
        assertTrue(isElementVisible(passwordInput), "Password field is not visible on Sign Up Screen");
        assertTrue(isElementVisible(confirmPasswordInput), "Confirm password field is not visible on Sign Up Screen");

    }

}
