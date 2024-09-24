package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProviders {
    Properties properties;

    public ConfigDataProviders() {
        File src = new File("./Configuration/config.properties");

        try {
            FileInputStream fis= new FileInputStream(src);

            properties= new Properties();

            properties.load(fis);
        } catch (Exception e) {
            System.out.println("Not able to load config file "+e.getMessage());
        }
    }


    public String getBrowser() {
        return properties.getProperty("browser");
    }



    public String getURL() {
        return properties.getProperty("URL");
    }
}
