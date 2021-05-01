package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;
import static io.github.bonigarcia.wdm.WebDriverManager.edgedriver;

public class DriverFactory {
    public WebDriver getChromeDriver() {
        chromedriver().setup();
        return new ChromeDriver();
    }

    public WebDriver getFirefoxDriver() {
        firefoxdriver().setup();
        return new FirefoxDriver(new FirefoxProfile());
    }

    public WebDriver getEdgeDriver() {
        edgedriver().setup();
        return new EdgeDriver();
    }
}
