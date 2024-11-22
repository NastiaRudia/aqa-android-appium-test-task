package base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream == null) {
                throw new RuntimeException("Configuration file 'config.properties' not found in classpath");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration properties", e);
        }
    }

    private PropertiesUtils() {
    }

    public static String getConfigProperty(String key) {
        return properties.getProperty(key);
    }

}
