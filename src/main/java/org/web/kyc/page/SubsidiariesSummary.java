package org.web.kyc.page;

import org.testng.annotations.Test;

public class SubsidiariesSummary extends KYCTestBase {

    @Test
    public void verifySubsidiariesSummaryPage(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl() + "/#/legalEntity/211/ownership/subsidiaries/summary");
      checkPageLayout("specs/subsidiariesSummary.gspec");
    }

}
