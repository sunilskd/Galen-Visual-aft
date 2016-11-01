package org.web.kyc.page;

import org.testng.annotations.Test;

public class GroupStructure extends KYCTestBase {

    @Test
    public void verifyGroupStructurePage(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl() + "/#/legalEntity/LE-6/ownership/groupStructure/summary");
        //dumpPage("GroupStructure", "specs/groupStructure.gspec","groupStructure");
        checkPageLayout("specs/groupStructure.gspec");
    }

}
