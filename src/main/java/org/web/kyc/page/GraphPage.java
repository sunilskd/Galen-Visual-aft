package org.web.kyc.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shahc1 on 10/19/2016.
 */
public class GraphPage extends KYCTestBase {

    private By zoomOutButton = By.xpath(".//*[@name='zoom-out']");
    private By allNodesxpath = By.xpath("//*[local-name()='g'][contains(@class,'node')]");
    private String nodeOnLevelxpath = "//*[local-name()='g'][contains(@class,'node')][@parent='";

    @Test
    public void verifyOwnersGraph() throws Exception {
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl() + "/#/legalEntity/211/ownership/owners/graph");
        clickOnZoomOutButton();
        int parentValue=0;
        determiningNumberOfLevels(allNodesxpath,parentValue);
        determiningNodesOnEachLevel(nodeOnLevelxpath,parentValue);
    }

    @Test
    public void verifySubsGraph() throws Exception {
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl() + "/#/legalEntity/211/ownership/subsidiaries/graph");
        clickOnZoomOutButton();
        int parentValue=0;
        determiningNumberOfLevels(allNodesxpath,parentValue);
        determiningNodesOnEachLevel(nodeOnLevelxpath,parentValue);
    }

    @Test
    public void verifyFullGraph() throws Exception {
        openWebApp("");
        login(readProperties.getUboUser());
        openWebApp(readProperties.getUrl() + "/#/legalEntity/211/ownership/groupStructure/graph");
        clickOnZoomOutButton();
        int parentValue=0;
        determiningNumberOfLevels(allNodesxpath,parentValue);
        determiningNodesOnEachLevel(nodeOnLevelxpath,parentValue);
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

    public void determiningNumberOfLevels(By allNodesxpath,int parentValue){
        List<WebElement> allNodes = getDriver().findElements(allNodesxpath);
        for(WebElement node : allNodes){
            int parentLevel = Integer.parseInt(node.getAttribute("parent"));
            if(parentValue<parentLevel){
                parentValue = parentLevel;
            }
        }
        System.out.println("***************No. of Levels in graph are :"+parentValue+"**************");
    }

    public void determiningNodesOnEachLevel(String nodeOnLevelxpath, int parentValue) throws Exception {
       /* So we need the below three lines are we need to create dynamic arraylist which can store node from each elements
       * In the for loop from line 61 to 64 we are storing elements from each level in the respective array
       */

        int totalLevels =0;
        totalLevels = parentValue;
        totalLevels++;
//        System.out.println("No of array created are :"+totalLevels);
        List<WebElement> nodeOnLevel[] = new ArrayList[totalLevels];
        for(int i=0;i<=parentValue;i++){
            nodeOnLevel[i]= getDriver().findElements(By.xpath(nodeOnLevelxpath+Integer.toString(i)+"']"));
//            System.out.println("Number of node on Level"+i+":"+nodeOnLevel[i].size());
        }
        /*
        * The below for loop shall iterate through node collected from each level (Line 70)
        * IF loop would check if level has more than one node present (Line 71)
        * FOR loop would iterate through the list which contains all the nodes present on that level and in that for loop we are extracting the co-ordinates of the node (Line 76)
        * */
        for(int i=0;i<nodeOnLevel.length;i++){
            /*
               * The below loop is only for validating x axis difference.
               *
               **/
            if (nodeOnLevel[i].size() > 1) {
                List<Float> x_axisValue = new ArrayList<Float>();
                String[] co_ordinates;
//                System.out.println("This node is eligible for next node comparison");
                for (int j = 0; j<nodeOnLevel[i].size(); j++) {
//                    System.out.println("Node position is :"+nodeOnLevel[i].get(j).getAttribute("transform"));
                    co_ordinates = nodeOnLevel[i].get(j).getAttribute("transform").split(",");
                    for(String xco_ordinate: co_ordinates){
                        if(xco_ordinate.contains("translate")){
                            xco_ordinate = xco_ordinate.substring(10);
                            x_axisValue.add(Float.parseFloat(xco_ordinate));
                        }
                    }
                }

                   /* * The below lines of the code are used for comparing the value of the X co-ordinates which we have stored in a list in the above code.
                    * x_axisValue is the list which has all the X axis values of the nodes which are present at the level which has more than 1 node
                    *
                    *
                    * */
                int a = 0;
                int b = a+1;
                for(int size=0;size<=x_axisValue.size();size++){
                    if(b<x_axisValue.size()){
                        if(x_axisValue.get(a)-x_axisValue.get(b)>=210 || x_axisValue.get(a)-x_axisValue.get(b)==0 || x_axisValue.get(a)-x_axisValue.get(b)<=-210){
//                            System.out.println("Nodes are not overlapping on X axis");
                        }else{

                            throw new Exception("Node are overlapping on X axis:"+x_axisValue.get(a)+" and "+x_axisValue.get(b));
                        }
                        a++;
                        b++;
                    }
                }

            }
        }
        /*
        * This section of code is used to calculate node distance between each levels
        * Here we are selecting one node from each level and comparing the distance with another node from another level
        *
        *
        * */
        List<Float> y_axisValue = new ArrayList<Float>();
        for (int j=0;j<nodeOnLevel.length;j++) {
            if (nodeOnLevel[j].size() > 1) {
                String[] yCo_Ordinates = nodeOnLevel[j].get(0).getAttribute("transform").split(",");
                for (String yco_ordinate : yCo_Ordinates) {
                    if (!yco_ordinate.contains("translate")) {
                        yco_ordinate = yco_ordinate.replace("0)", "0");
                        y_axisValue.add(Float.parseFloat(yco_ordinate));

                    }
                }
            }
        }
        int a = 0;
        int b = a + 1;
        for (int size = 0; size <= y_axisValue.size(); size++) {
            if (b < y_axisValue.size()) {
                if (y_axisValue.get(a) - y_axisValue.get(b) >= 250.0 || y_axisValue.get(a) - y_axisValue.get(b) <= -250.0 || y_axisValue.get(a) - y_axisValue.get(b) == 0) {
//                    System.out.println("Nodes are not overlapping on Y axis");
                } else {
                    
                    throw new Exception("Node are overlapping on Y axis:" + y_axisValue.get(a) + " and " + y_axisValue.get(b));
                }
                a++;
                b++;
            }

        }

    }
}
