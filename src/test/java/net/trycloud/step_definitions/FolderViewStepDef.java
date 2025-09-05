package net.trycloud.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.trycloud.pages.FolderViewPage;
import net.trycloud.utilities.BrowserUtils;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;

public class FolderViewStepDef {

    List<String> actualelement;
    FolderViewPage page = new FolderViewPage();

    String beforeToggle;
    @And("the user clicks on name")
    public void theUserClicksOnName() {
        if(page.toggleview.getAttribute("class").contains("filelist")){
            page.toggleview.click();
            BrowserUtils.waitFor(1);
        }
        actualelement = BrowserUtils.getElementsText(page.listoffiles);
        System.out.println("before click"+actualelement);
        page.name.click();
    }


    @Then("the view of folders should change by name")
    public void theViewOfFoldersShouldChangeByName() {
        List<String> expected = BrowserUtils.getElementsText(page.listoffiles);
        Collections.sort(actualelement);

        System.out.println("expected after click"+expected);
        System.out.println("actualelement = " + actualelement);


    }

    @And("the user clicks on size")
    public void theUserClicksOnSize() {

        if(page.toggleview.getAttribute("class").contains("filelist")){
            page.toggleview.click();
            BrowserUtils.waitFor(1);
        }
        actualelement = BrowserUtils.getElementsText(page.listofsize);
        System.out.println("before click"+actualelement);
        page.size.click();

    }

    @Then("the order of the folders should change by size")
    public void theOrderOfTheFoldersShouldChangeBySize() {

        List<String> ex = BrowserUtils.getElementsText(page.listofsize);
        Collections.sort(actualelement);

        System.out.println("after click"+ex);
        Assert.assertEquals(ex,actualelement);

    }

    @And("the user clicks on modified")
    public void theUserClicksOnModified() {
        if(page.toggleview.getAttribute("class").contains("filelist")){
            page.toggleview.click();
            BrowserUtils.waitFor(1);
        }
        actualelement = BrowserUtils.getElementsText(page.listofmodels);
        System.out.println("before click"+actualelement);
        page.modified.click();

    }

    @Then("the order of the folders should change by date")
    public void theOrderOfTheFoldersShouldChangeByDate() {


        List<String> exp = BrowserUtils.getElementsText(page.listofmodels);
        Collections.sort(actualelement);

        System.out.println("after click"+exp);
        Assert.assertEquals(exp,actualelement);

    }

    @And("the user clicks on toggle view")
    public void theUserClicksOnToggleView() {

        BrowserUtils.waitFor(1);
        beforeToggle = page.toggleview.getAttribute("class");
        BrowserUtils.waitFor(1);
        page.toggleview.click();

        System.out.println("beforeToggle = " + beforeToggle);

       }


    @Then("the order of the folders should change by view")
    public void theOrderOfTheFoldersShouldChangeByView() {
        BrowserUtils.waitFor(1);
        String afterToggle = page.toggleview.getAttribute("class");
        System.out.println("afterToggle = " + afterToggle);
        Assert.assertNotEquals(beforeToggle,afterToggle);

    }

}
