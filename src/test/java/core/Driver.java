package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import utils.CommonUtils;
import utils.Logger;
import java.io.File;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class Driver {
    private static WebDriver webDriver = null;
    private static final String SCREENSHOTS_FOLDER = "";

    public synchronized static void start() {
        if (webDriver == null) {
            Logger.info("WebDriver not initialized. Starting one now...");
            try {
                launchDriver();
                Logger.exception(new Exception("Unable to initialize the web driver !!!"));
                Logger.info("WebDriver started.");
            } catch (Exception e) {
                Logger.error("Unable to initialize the web driver !!!");
                Logger.exception(e);
            }
        }
    }

    public synchronized static WebDriver driver() {
        return webDriver;
    }

    public static void screenShot() {
        try {
            File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            String screenshotFileName = "screenshot_" + CommonUtils.getTimeStamp("yyyyMMdd_HHmmss") + ".png";
            String destFile = SCREENSHOTS_FOLDER + screenshotFileName;
            FileUtils.copyFile(srcFile, new File(destFile));
            Logger.info("Screenshot saved to: " + destFile);
        } catch (Exception e) {
            Logger.exception(e);
        }
    }

    public synchronized static void close() {
        if (webDriver != null) {
            Logger.info("Closing open sessions...");
            webDriver.quit();
            webDriver = null;
        }
    }

    private static void launchDriver() {
        switch(Configuration.getConfig("browser").toLowerCase()) {
            case "firefox":
                Logger.info("Initialising Firefox driver...");
                firefoxdriver().setup();
                webDriver = new FirefoxDriver(new FirefoxProfile());
                break;
            case "chrome":
            default:
                Logger.info("Initialising Chrome driver...");
                chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
        }
    }
}
