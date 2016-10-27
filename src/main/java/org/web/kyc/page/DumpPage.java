package org.web.kyc.page;

import org.testng.annotations.Test;

public class DumpPage extends KYCTestBase {

    @Test
    public void dumpEntityDetailsPage(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl() + "/#/legalEntity/58285/entityDetails");
        dumpPage("Entity Details","specs/entitydetails.gspec","entitydetails");
    }

    @Test
    public void dumpOwnersGraphPage(){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl() + "/#/legalEntity/11262/ownership/owners/graph");
        dumpPage("Owners Graph","specs/graphs.gspec","ownersgraph");
    }
}
