package org.web.kyc.page;

import org.testng.annotations.Test;

public class DumpPage extends KYCTestBase {

    @Test
    public void dumpPage(){
        openWebApp("");
        login("gajendraubo");
        openWebApp("https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/58285/entityDetails");
        dumpPage("Entity Details","specs/entitydetails.gspec","entitydetails");
    }
}
