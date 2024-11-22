package base.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import static base.AppiumListener.APP_PATH;
import static base.AppiumListener.getAppiumUrl;
import static base.PropertiesUtils.getConfigProperty;

public class AndroidLocal implements IDeviceConfig {

    @Override
    public AndroidDriver setupDriver() {
        UiAutomator2Options capabilities;
        capabilities = new UiAutomator2Options();
        capabilities.setCapability("platformName", getConfigProperty("platform.name"));
        capabilities.setCapability("platformVersion", getConfigProperty("platform.version"));
        capabilities.setCapability("deviceName", getConfigProperty("device.name"));
        capabilities.setCapability("automationName", getConfigProperty("automationName"));
        capabilities.setCapability("app", APP_PATH);
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("fullReset", false);
        try {
            return new AndroidDriver(getAppiumUrl(), capabilities);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
