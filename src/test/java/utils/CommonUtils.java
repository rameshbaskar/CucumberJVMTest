package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class CommonUtils {

    public static void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            // Do Nothing
        }
    }

    public static String getTimeStamp(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }
}
