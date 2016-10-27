package org.web.kyc.page;

import org.testng.annotations.Test;

public class SubsidiaryList extends KYCTestBase {

    @Test
    public void verifySusbsidiarySummaryPage(){
        openWebApp("");
        login("sunilubo");
        openWebApp("https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/3/ownership/subsidiaries/summary");
        //dumpPage("Subsidiaries","specs/subsidiaries.gspec","subsidiaries");
        checkPageLayout("specs/subsidiaries.gspec");
    }

}
