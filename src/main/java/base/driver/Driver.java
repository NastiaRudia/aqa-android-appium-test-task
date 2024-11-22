package base.driver;

import io.appium.java_client.AppiumDriver;

public class Driver {

    private static final ThreadLocal<DriverSession> driverSessionThreadLocal = new ThreadLocal<>();

    public static void initiateDriverSession() {
        IDeviceConfig iDeviceConfig = DeviceConfigFactory.getDeviceConfig();
        driverSessionThreadLocal.set(new DriverSession(iDeviceConfig));
    }

    public static AppiumDriver getDriver() {
        return driverSessionThreadLocal.get()
                .getDriver();
    }

    public static void quitDriverSession() {
        if (null != getDriver()) {
            getDriver().quit();
        }
    }
}
