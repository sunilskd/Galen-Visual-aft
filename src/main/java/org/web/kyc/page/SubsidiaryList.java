package org.web.kyc.page;

import org.testng.annotations.Test;

public class SubsidiaryList extends KYCTestBase {

    public String subsSummary = "https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/211/ownership/subsidiaries/summary";

    @Test
    public void verifySusbsidiarySummaryPage(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(subsSummary);
        getDriver().manage().window().maximize();

        //dumpPage("Subsidiaries","specs/subsidiaries.gspec","subsidiaries");
      checkPageLayout("specs/subsidiaries.gspec");
    }

}
