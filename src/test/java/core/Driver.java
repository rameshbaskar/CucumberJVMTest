package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import utils.CommonUtils;
import utils.Logger;

import java.io.File;
import java.io.IOException;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class Driver {
    private static WebDriver webDriver = null;

    public synchronized static void start() {
        try {
            webDriver = new FirefoxDriver(new FirefoxProfile());
            Logger.info("WebDriver started.");
        } catch (Exception e) {
            Logger.error("Unable to initialize the web driver !!!");
            Logger.exception(e);
        }
    }

    public synchronized static WebDriver driver() {
        if (webDriver == null) {
            Logger.info("WebDriver not initialized. Starting one now...");
            start();
        }
        return webDriver;
    }

    public static void screenShot() {
        if (webDriver != null) {
            try {
                File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
                String destFile = "results/screenshot_" + CommonUtils.timeStamp() + ".png";
                FileUtils.copyFile(srcFile, new File(destFile));
                Logger.info("Screenshot saved to: " + destFile);
            } catch (IOException e) {
                Logger.exception(e);
            }
        }
    }

    public static void close() {
        if (webDriver != null) {
            Logger.info("Closing open sessions...");
            webDriver.quit();
            webDriver = null;
        }
    }
}
