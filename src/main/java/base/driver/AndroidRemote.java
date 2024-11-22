package base.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import static base.AppiumListener.getAppiumUrl;

public class AndroidRemote implements IDeviceConfig {

    @Override
    public AndroidDriver setupDriver() {
        UiAutomator2Options capabilities = new UiAutomator2Options();
        // remote set up
        try {
            return new AndroidDriver(getAppiumUrl(), capabilities);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
