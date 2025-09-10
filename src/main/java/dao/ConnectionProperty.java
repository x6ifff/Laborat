package dao;

import java.io.IOException;
import java.util.Properties;

public class ConnectionProperty {
    public static final String CONFIG_NAME = "config.properties";
    public static final Properties PROPERTY_CONFIG = new Properties();

    static {
        try {
            ClassLoader classLoader = ConnectionProperty.class.getClassLoader();
            PROPERTY_CONFIG.load(classLoader.getResourceAsStream("config/" + CONFIG_NAME));
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Failed to load config file: " + CONFIG_NAME);
        }
    }

    public static String getProperty(String property) {
        return PROPERTY_CONFIG.getProperty(property);
    }
}