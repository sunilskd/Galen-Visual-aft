package org.web.kyc.page;

import com.galenframework.api.GalenPageDump;
import com.galenframework.testng.GalenTestNgTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.ReadProperties;

import java.io.IOException;

import static java.util.Arrays.asList;

/**
 * Created by sahug on 9/14/2016.
 */
public class KYCTestBase extends GalenTestNgTestBase {
    private By user_login_input_box_id = By.xpath("//input[@id='login']");
    private By login_button_xpath = By.xpath("//button[1]");
    public static ReadProperties readProperties = new ReadProperties();


    public WebDriver createDriver(Object[] args) {
    if (readProperties.getBrowser().equals("IE")){
        System.setProperty("webdriver.ie.driver", getClass().getResource("/InternetExplorerDriver.exe").getPath());
        return new InternetExplorerDriver();
        }else if (readProperties.getBrowser().equals("Chrome")){
         System.setProperty("webdriver.chrome.driver", getClass().getResource("/ChromeDriver.exe").getPath());
        return new ChromeDriver();
    }else if (readProperties.getBrowser().equals("Firefox")){
        return new FirefoxDriver();
    }
        return null;
    }

    public void openWebApp(String url){
        getDriver().manage().window().maximize();
        if(url.equals("")) {
            load(readProperties.getUrl() + "/#/login");
        }else load(url);
        getDriver().manage().window().maximize();
    }

    public void dumpPage(String pageName, String specPath, String dumpDir){
        GalenPageDump galenPageDump = new GalenPageDump(pageName);
        try {
            galenPageDump.dumpPage(getDriver(),specPath, "./src/test/resources/dump/pages/" + dumpDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkPageLayout(String specPath){
        try {
            checkLayout(specPath, asList("desktop"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login(String username){
        try {
            Thread.sleep(2000);
            getDriver().findElement(user_login_input_box_id).sendKeys(username);
            getDriver().findElement(login_button_xpath).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
