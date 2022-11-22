package mobileTesting.util.properties;


import static mobileTesting.util.properties.PropertyManager.getProperty;

public class PropertiesStorage {

    public static final String URL = getProperty("url");
    public static final String PLATFORM_NAME = getProperty("platform.name");
    public static final String AUTOMATION_NAME = getProperty("automation.name");
    public static final String APP_PACKAGE = getProperty("app.package");
    public static final String APP_ACTIVITY = getProperty("app.activity");
    public static final String PHYSICAL_UDID = getProperty("physical.udid");
    public static final String PHYSICAL_PLATFORM_VERSION = getProperty("physical.platform.version");
    public static final String VIRTUAL_UDID = getProperty("virtual.udid");
    public static final String VIRTUAL_PLATFORM_VERSION = getProperty("virtual.platform.version");
}