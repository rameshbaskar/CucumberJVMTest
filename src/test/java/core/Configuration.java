package core;

public class Configuration {
    public static String getConfig(String key) {
        return System.getenv(key);
    }
}
