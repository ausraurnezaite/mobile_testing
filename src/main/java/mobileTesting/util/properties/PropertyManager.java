package mobileTesting.util.properties;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertyManager {

    private static final Logger log = (Logger) LoggerFactory.getLogger(PropertyManager.class);

    private static final String PROPERTIES_PATH = "src/test/resources/properties/capabilities.properties";

    public static String getProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(new InputStreamReader(new FileInputStream(PROPERTIES_PATH), StandardCharsets.UTF_8));
        } catch (IOException exception) {
            log.error("Properties not found", exception);
        }
        return props.getProperty(name);
    }
}