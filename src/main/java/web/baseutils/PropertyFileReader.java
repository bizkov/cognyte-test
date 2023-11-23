package web.baseutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
    private static PropertyFileReader properties;
    private static Properties prop;
    private static final Logger LOGGER = LogManager.getLogger(PropertyFileReader.class);
    private static final String OS = System.getProperty("os.name").toLowerCase();
    private static final String BASE_PATH = System.getProperty("user.dir");

    private PropertyFileReader(String propertyFile) {
        try {
            readConfiguration(propertyFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PropertyFileReader getInstance(String propertyFile) {
        if (properties == null) {
            synchronized (PropertyFileReader.class) {
                if (properties == null) {
                    properties = new PropertyFileReader(propertyFile);
                }
            }
        }
        return properties;
    }

    private void readConfiguration(String propertyFile) throws Exception {

        String filePath = String.format("%s/%s", BASE_PATH, propertyFile);
        File file = new File(filePath);
        if (!file.exists()) {
            LOGGER.info(String.format("Properties file %s does not exist!", file.getPath()));
        }

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prop = new Properties();
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String geckoDriverPath;
//        String chromeDriverPath;
//        if (OS.contains("nix") || OS.contains("nux") || (OS.indexOf("aix") > 0)) {
//            // Linux
//            chromeDriverPath = BASE_PATH + "/bin/linux/chromedriver";
//            geckoDriverPath = BASE_PATH + "/bin/linux/geckodriver";
//        } else if (OS.contains("win")) {
//            // Win
//            chromeDriverPath = BASE_PATH + "\\bin\\win\\chromedriver.exe";
//            geckoDriverPath = BASE_PATH + "\\bin\\win\\geckodriver.exe";
//        } else {
//            throw new Exception("Could not detect OS");
//        }
//        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//        System.setProperty("webdriver.gecko.driver", geckoDriverPath);
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }
}
