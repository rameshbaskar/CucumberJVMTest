package core;

import org.openqa.selenium.WebDriver;

import static core.Configuration.getConfig;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class Driver {
    private static WebDriver webDriver;

    public synchronized static WebDriver getDriver() {
        if (webDriver == null) initDriver();
        return webDriver;
    }

    public synchronized static void stopDriver() {
        webDriver.quit();
        webDriver = null;
    }

    private synchronized static void initDriver() {
        DriverFactory driverFactory = new DriverFactory();
        switch (getConfig("BROWSER").toLowerCase()) {
            case "firefox":
                webDriver = driverFactory.getFirefoxDriver();
                break;
            case "edge":
                webDriver = driverFactory.getEdgeDriver();
                break;
            case "chrome":
            default:
                webDriver = driverFactory.getChromeDriver();
                break;
        }
    }
}
