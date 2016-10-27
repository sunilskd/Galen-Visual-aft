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
    private String kycUser;

    public ReadProperties(){
        setBrowser(getProjectProperties("test.properties","kyc.web.browser"));
        setUrl(getProjectProperties("test.properties","kyc.web.url"));
        setUboUser(getProjectProperties("test.properties","kyc.ubo.user.login.id"));
        setKycUser(getProjectProperties("test.properties","kyc.kyc.user.login.id"));
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

    public String getKycUser() {
        return kycUser;
    }

    public void setKycUser(String kycUser) {
        this.kycUser = kycUser;
    }





}
