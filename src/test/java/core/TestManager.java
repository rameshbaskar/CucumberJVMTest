package core;

import utils.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Ramesh Baskarasubramanian on 6/11/15.
 */
public class TestManager {

    private static Properties properties;

    public static void loadConfiguration() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(new FileInputStream(new File("environment.properties")));
                Logger.info("properties loaded.");
            } catch (Exception e) {
                Logger.error("Unable to read the properties !!!");
                Logger.exception(e);
            }
        }
    }

    public static String baseUrl() {
        return getProperty("base.url");
    }

    public static String dbDriver() {
        return getProperty("database.driver");
    }

    public static String dbUrl() {
        return getProperty("database.url");
    }

    public static String dbUsername() {
        return getProperty("database.username");
    }

    public static String dbPassword() {
        return getProperty("database.password");
    }

    public static void prepareResultsFolder() {
        File dir = new File("results");
        dir.delete();
        dir.mkdir();
    }

    private static String getProperty(String key) {
        String value = properties.getProperty(key);
        Logger.info("Property fetched: " + key + " = " + value);
        return value;
    }
}
