package mobileTesting.util.desiredCapabilitiesManager;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static mobileTesting.util.properties.PropertiesStorage.*;

public class DesiredCapabilitiesManager {
    private static boolean virtual = Boolean.parseBoolean(System.getProperty("virtual"));

    public static DesiredCapabilities getDesiredCapabilities() {

        if (virtual) {
            return getVirtualDeviceDesiredCapabilities();
        }
        return getPhysicalDeviceDesiredCapabilities();
    }

    private static DesiredCapabilities getVirtualDeviceDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, VIRTUAL_UDID);
        desiredCapabilities.setCapability("platformVersion", VIRTUAL_PLATFORM_VERSION);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
        desiredCapabilities.setCapability("appPackage", APP_PACKAGE);
        desiredCapabilities.setCapability("appActivity", APP_ACTIVITY);
        return desiredCapabilities;
    }

    private static DesiredCapabilities getPhysicalDeviceDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, PHYSICAL_UDID);
        desiredCapabilities.setCapability("platformVersion", PHYSICAL_PLATFORM_VERSION);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
        desiredCapabilities.setCapability("appPackage", APP_PACKAGE);
        desiredCapabilities.setCapability("appActivity", APP_ACTIVITY);
        return desiredCapabilities;
    }
}