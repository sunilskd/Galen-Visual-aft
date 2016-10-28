package org.web.kyc.page;

import org.testng.annotations.Test;


/**
 * Created by shahc1 on 10/14/2016.
 */
public class OwnersSummary extends KYCTestBase {
    
    @Test
    public void verifyOwnersSummaryPage(){

        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl()+"/#/legalEntity/LE-A/ownership/owners/summary");

        checkPageLayout("specs/ownersSummary.gspec");
    }
}
