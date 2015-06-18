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
        String url = properties.getProperty("base.url");
        Logger.info("base.url=" + url);
        return url;
    }

    public static void prepareResultsFolder() {
        File dir = new File("results");
        dir.delete();
        dir.mkdir();
    }
}
