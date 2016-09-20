import org.testng.annotations.Test;

public class EntityDetails extends KYCTestBase{

    @Test
    public void verifyEntityDetailsPage(){
        openWebApp("");
        login("gajendraubo");
        openWebApp("https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/211/entityDetails");
        dumpPage("Entity Details","specs/entitydetails.gspec","entitydetails");
        checkPageLayout("specs/entitydetails.gspec");
    }
}
