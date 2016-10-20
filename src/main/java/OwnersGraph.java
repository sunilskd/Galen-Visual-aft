import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by shahc1 on 10/19/2016.
 */
public class OwnersGraph extends KYCTestBase {

    private By zoomOutButton = By.xpath("//*[@id='content-view']/div[4]/div[1]/div/fieldset/button[2]");
    public String ownersGraph = "https://internal-uboqa-web-1999720210.us-east-1.elb.amazonaws.com/kyc-webapp/#/legalEntity/1038/ownership/owners/graph";

    @Test
    public void verifyOwnersSummaryPage(){

        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(ownersGraph);
        clickOnZoomOutButton();
//        dumpPage("Owners Graph","specs/ownersGraph.gspec","ownersGraph");
        checkPageLayout("specs/ownersGraph.gspec");
    }

    public void clickOnZoomOutButton(){
        try{
        Thread.sleep(3000L);
        for(int i=0;i<8;i++)
        getDriver().findElement(zoomOutButton).click();
    }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
