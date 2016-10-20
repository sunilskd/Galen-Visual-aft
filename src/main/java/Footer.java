import org.testng.annotations.Test;

/**
 * Created by shahc1 on 10/20/2016.
 */
public class Footer extends KYCTestBase{

    public String entityDetails = "https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/1991/entityDetails";
    public String groupStructureSummary = "https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/1038/ownership/groupStructure/summary";
    public String groupStructureGraph = "https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/1038/ownership/groupStructure/graph";
    public String ownersSummary = "https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/1038/ownership/owners/summary";
    public String ownersGraph = "https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/1038/ownership/owners/graph";
    public String subsSummary  = "https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/1038/ownership/subsidiaries/summary";
    public String subsGraph = "https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/1038/ownership/subsidiaries/graph";

    @Test
    public void validateFooterOnEntityDetails(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(entityDetails);
//        dumpPage("Footer","specs/footer.gspec","footer");
        checkPageLayout("specs/footer.gspec");

    }


    @Test
    public void validateFooterOnGroupStructureSummary(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(groupStructureSummary);
//        dumpPage("Footer","specs/footer.gspec","footer");
        checkPageLayout("specs/footer.gspec");
    }

    @Test
    public void validateFooterOnOwnerSummary(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(ownersSummary);
        checkPageLayout("specs/footer.gspec");
    }

    @Test
    public void validateFooterOnSubsSummary(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(subsSummary);
        checkPageLayout("specs/footer.gspec");
    }

    @Test
    public void validateFooterOnGroupStructureGraph(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(groupStructureGraph);
        checkPageLayout("specs/footer.gspec");
    }

    @Test
    public void validateFooterOnOwnersGraph(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(ownersGraph);
        checkPageLayout("specs/footer.gspec");
    }

    @Test
    public void validateFooterOnSubsGraph(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(subsGraph);
        checkPageLayout("specs/footer.gspec");
    }


}
