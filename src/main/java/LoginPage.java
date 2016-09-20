import org.testng.annotations.Test;

public class LoginPage extends KYCTestBase{

    @Test
    public void verifyLoginPage(){
        openWebApp("");
        dumpPage("Login Page", "specs/login.gspec", "login");
        checkPageLayout("specs/login.gspec");
    }



}
