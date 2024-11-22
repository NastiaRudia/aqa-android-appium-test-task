package base.driver;

import io.appium.java_client.android.AndroidDriver;

public class DriverSession {

    private final AndroidDriver driver;

    public DriverSession(IDeviceConfig iDeviceConfig) {
        driver = iDeviceConfig.setupDriver();
    }

    public AndroidDriver getDriver() {
        return driver;
    }
}
