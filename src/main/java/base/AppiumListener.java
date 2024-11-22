package base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.File;
import java.net.URL;

import static base.PropertiesUtils.getConfigProperty;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.LOG_LEVEL;

public class AppiumListener implements ISuiteListener {

    private static final Logger logger = LoggerFactory.getLogger(AppiumListener.class);
    public static String APP_PATH;
    public static AppiumDriverLocalService appiumService;

    public static URL getAppiumUrl() {
        return appiumService.getUrl();
    }

    private static synchronized void startAppium() {
        if (appiumService == null || !appiumService.isRunning()) {
            appiumService = AppiumDriverLocalService.buildService(
                    new AppiumServiceBuilder()
                            .usingAnyFreePort()
                            .withArgument(LOG_LEVEL, "warn"));
            logger.info("Starting Appium Server");
            appiumService.start();
        }
    }

    @Override
    public void onStart(ISuite suite) {
        APP_PATH = getAppAbsolutePath();
        startAppium();
    }

    @Override
    public void onFinish(ISuite suite) {
        if (appiumService != null && appiumService.isRunning()) {
            logger.info("Stopping Appium Server");
            appiumService.stop();
        }
    }

    private String getAppAbsolutePath() {
        String appName = getConfigProperty("app.name");
        URL resource = getClass().getClassLoader().getResource(appName);
        if (resource == null) {
            throw new RuntimeException("App not found " + appName + " in resource directory");
        }
        try {
            return new File(resource.toURI()).getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Something went wrong for app: " + appName);
        }
    }

}
