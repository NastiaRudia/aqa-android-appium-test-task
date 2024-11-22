package base.driver;

import java.util.HashMap;
import java.util.Map;

import static base.PropertiesUtils.getConfigProperty;

public class DeviceConfigFactory {

    static Map<String, IDeviceConfig> deviceConfigurations = new HashMap<>();

    static {
        deviceConfigurations.put("local", new AndroidLocal());
        deviceConfigurations.put("remote", new AndroidRemote());
    }

    private DeviceConfigFactory() {
    }

    public static IDeviceConfig getDeviceConfig() {
        return deviceConfigurations.get(getConfigProperty("run.infrastructure"));
    }
}
