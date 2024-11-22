package co.obrio;

import base.AppiumListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import screens.OnboardingScreen;
import screens.SignUpScreen;
import screens.WelcomeScreen;

import static base.driver.Driver.initiateDriverSession;
import static base.driver.Driver.quitDriverSession;

@Listeners({AppiumListener.class})
public class BaseFixture {

    protected WelcomeScreen welcomeScreen = new WelcomeScreen();
    protected OnboardingScreen onboardingScreen = new OnboardingScreen();
    protected SignUpScreen signUpScreen = new SignUpScreen();

    @BeforeClass(description = "Initiate driver")
    public void setUp() {
        initiateDriverSession();
    }

    @AfterClass(description = "Quit driver")
    public void tearDown() {
        quitDriverSession();
    }
}
