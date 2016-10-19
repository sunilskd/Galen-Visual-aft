import com.galenframework.api.GalenPageDump;
import com.galenframework.support.GalenJavaTestBase;
import com.galenframework.testng.GalenTestNgTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static java.util.Arrays.asList;

/**
 * Created by sahug on 9/14/2016.
 */
public class KYCTestBase extends GalenTestNgTestBase {
    String WEB_APP_URL = "https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/login";
    private By user_login_input_box_id = By.xpath("//input[@id='login']");
    private By login_button_xpath = By.xpath("//button[1]");


    /**
     * Used in order to initialize a {@link WebDriver}
     *
     * @param args the arguments of current test
     * @return
     */
//    @Override
//    public WebDriver createDriver(Object[] args) {
//        return null;
//    }






    public WebDriver createDriver(Object[] args) {
    System.out.print("Check");
    if (System.getProperty("browserName").equals("IE")){
        System.setProperty("webdriver.ie.driver", getClass().getResource("/InternetExplorerDriver.exe").getPath());
        return new InternetExplorerDriver();
        }else if (System.getProperty("browserName").equals("Chrome")){
         System.setProperty("webdriver.chrome.driver", getClass().getResource("/ChromeDriver.exe").getPath());
        return new ChromeDriver();
    }else{
        return new FirefoxDriver();
    }


    }

    public void openWebApp(String url){
        if(url.equals("")) {
            load(WEB_APP_URL);
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
