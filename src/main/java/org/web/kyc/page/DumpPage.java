package org.web.kyc.page;

import org.testng.annotations.Test;

public class DumpPage extends KYCTestBase {

    @Test
    public void dumpEntityDetailsPage(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl() + "/#/legalEntity/58285/entityDetails");
        dumpPage("Entity Details", "specs/entityDetails.gspec","entityDetails");
    }

    @Test
    public void dumpOwnersSummaryPage(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl()+"/#/legalEntity/LE-A/ownership/owners/summary");
        dumpPage("Owners Summary", "specs/ownersSummary.gspec","ownersSummary");
    }

    @Test
    public void dumpSubsidiarySummaryPage(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl() + "/#/legalEntity/3/ownership/subsidiaries/summary");
        dumpPage("Subsidiaries", "specs/subsidiariesSummary.gspec","subsidiariesSummary");
    }

    @Test
    public void dumpGroupStructurePage(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl() + "/#/legalEntity/846/ownership/groupStructure/summary");
        dumpPage("GroupStructure", "specs/groupStructure.gspec","groupStructure");
    }


}
