package org.web.kyc.page;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SubsidiaryGraph extends KYCTestBase {

    @Test
    public void verifySubsGraphPage() {
        By graph_zoom_out_xpath = By.xpath(".//div/div/div/fieldset/button[2]");
        openWebApp("");
        login("sunilubo");
        openWebApp("https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/3/ownership/subsidiaries/graph");

        try {

            Thread.sleep(3000L);
            getDriver().findElement(graph_zoom_out_xpath).click();
            getDriver().findElement(graph_zoom_out_xpath).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //dumpPage("SubsidiariesGraph","specs/subsidiariesgraph.gspec","subsidiariesGraph");
        checkPageLayout("specs/subsidiariesgraph.gspec");

    }
}
