import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by shahc1 on 10/14/2016.
 */
public class OwnersSummary extends KYCTestBase {

    @BeforeClass
    public void loadSystemValue(){
        System.setProperty("browserName","Chrome");
    }
    @Test
    public void verifyOwnersSummaryPage(){

        openWebApp("");
        login("testubo");
        openWebApp("https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/1038/ownership/owners/summary");
       // dumpPage("Owners Summary","specs/ownersSummary.gspec","ownersSummary");
        checkPageLayout("specs/ownersSummary.gspec");
    }
}
