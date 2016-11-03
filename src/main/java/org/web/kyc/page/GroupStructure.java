package org.web.kyc.page;

import org.testng.annotations.Test;

public class GroupStructure extends KYCTestBase {

    @Test
    public void verifyGroupStructurePage(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl() + "/#/legalEntity/846/ownership/groupStructure/summary");
        checkPageLayout("specs/groupStructure.gspec");
    }

}
