package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by shahc1 on 10/20/2016.
 */
public class ReadProperties {
    private String url;
    private String browser;
    private String uboUser;

    public ReadProperties(){
        setBrowser(getProjectProperties("visualTesting.properties","browserName"));
        setUrl(getProjectProperties("visualTesting.properties","url"));
        setUboUser(getProjectProperties("visualTesting.properties","uboUser"));
    }


    public String getProjectProperties(String propertyFile, String property) {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFile);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUboUser() {
        return uboUser;
    }

    public void setUboUser(String uboUser) {
        this.uboUser = uboUser;
    }


    public String getBrowser() {
        return browser;
    }




}
