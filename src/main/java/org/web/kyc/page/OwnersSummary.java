package org.web.kyc.page;

import org.testng.annotations.Test;

public class OwnersSummary extends KYCTestBase {

    @Test
    public void verifyOwnersSummaryPage(){

        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl()+"/#/legalEntity/73125/ownership/owners/summary");

        checkPageLayout("specs/ownersSummary.gspec");
    }
}
