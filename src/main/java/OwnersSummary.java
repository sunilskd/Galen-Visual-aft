
import org.testng.annotations.Test;


/**
 * Created by shahc1 on 10/14/2016.
 */
public class OwnersSummary extends KYCTestBase {

    public String ownersSummary = "https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/1038/ownership/owners/summary";
    @Test
    public void verifyOwnersSummaryPage(){

        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(ownersSummary);
       // dumpPage("Owners Summary","specs/ownersSummary.gspec","ownersSummary");
        checkPageLayout("specs/ownersSummary.gspec");
    }
}
