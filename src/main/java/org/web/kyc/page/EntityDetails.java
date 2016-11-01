package org.web.kyc.page;

import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class EntityDetails extends KYCTestBase {

    @DataProvider(name = "fid")
    public static Iterator<Object[]> fidList(){
        Collection<Object[]> fid = new ArrayList<Object[]>() {
            {
                add(new Object[] {"1038"});
                add(new Object[] {"211"});
                add(new Object[] {"815"});
                add(new Object[] {"58285"});
            }
        };
        return fid.iterator();
    }

    @Test(dataProvider = "fid")
    public void verifyEntityDetailsPage(String fid){
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl() + "/#/legalEntity/" + fid + "/entityDetails");
        checkPageLayout("specs/entityDetails.gspec");
    }

}
