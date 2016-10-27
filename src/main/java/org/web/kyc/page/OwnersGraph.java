package org.web.kyc.page;

import org.testng.annotations.Test;

/**
 * Created by sahug on 9/30/2016.
 */
public class OwnersGraph extends KYCTestBase {

    @Test
    public void verifyOwnersGraphPage(){
        openWebApp("");
        login("gajendraubo");
        openWebApp("https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/11262/ownership/owners/graph");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dumpPage("Owners Graph","specs/graphs.gspec","ownersgraph");
        //checkPageLayout("specs/entitydetails.gspec");
    }
}
