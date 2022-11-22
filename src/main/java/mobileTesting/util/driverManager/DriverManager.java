package mobileTesting.util.driverManager;

import ch.qos.logback.classic.Logger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import mobileTesting.util.desiredCapabilitiesManager.DesiredCapabilitiesManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static mobileTesting.util.properties.PropertiesStorage.URL;

public class DriverManager {
    private static AndroidDriver<AndroidElement> driver;
    private static final Logger log = (Logger) LoggerFactory.getLogger(DriverManager.class);

    public static AndroidDriver<AndroidElement> getDriver() {
        if (driver != null) {
            return driver;
        }
        try {
            DesiredCapabilities desiredCapabilities = DesiredCapabilitiesManager.getDesiredCapabilities();
            driver = new AndroidDriver<>(new URL(URL), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            log.info(String.format("Connected to appium server %s", URL));

        } catch (MalformedURLException e) {
            log.error("Error when connecting with Appium server.", e);
        }
        return driver;
    }

    public static void tearDown() {
        driver.quit();
        log.info("AndroidDriver quit");
    }
}