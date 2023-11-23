package web.utilsweb;

import web.baseutils.PropertyFileReader;

public interface UIConstants {

    String USER_EMAIL = PropertyFileReader.getInstance("web.properties").getProperty("userName");
    String USER_PASSWORD = PropertyFileReader.getInstance("web.properties").getProperty("loginPassword");
    String CHROME_BROWSER = PropertyFileReader.getInstance("web.properties").getProperty("chromeBrowser");
    String FIREFOX_BROWSER = PropertyFileReader.getInstance("web.properties").getProperty("firefoxBrowser");
}
