package utils;

import core.Driver;

/**
 * Created by rameshb on 6/10/15.
 */
public class Logger {
    public static void info(String message) {
        System.out.println("[INFO] " + getFormattedMessage(message));
    }

    public static void error(String message) {
        System.err.println("[WARN] " + getFormattedMessage(message));
    }

    public static void exception(Exception exception) {
        Driver.screenShot();
        System.err.println("Fatal exception has occurred !!! Below is the stacktrace for debugging purposes.");
        exception.printStackTrace();
        Driver.close();
        System.exit(0);
    }

    private static String getFormattedMessage(String message) {
        return "[" + CommonUtils.getTimeStamp("yyyy-MM-dd HH:mm:ss") + "] " + message;
    }
}
