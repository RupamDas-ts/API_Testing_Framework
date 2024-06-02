package TestConfigSetup;

import Constants.FrameworkConstants;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public final class TestProperties {
    private static HashMap<String, Object> creds = new HashMap<>();
    static {
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH);
            Yaml yaml = new Yaml();
            creds = yaml.load(fis);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Object getProperty(String envName) {
        return creds.get(envName);
    }
}
