package net.trycloud.step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.NewGroupContactsPage;
import net.trycloud.utilities.BrowserUtils;
import net.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;



public class NewGroupContactDefs {
    @When("the user click {string} module")
    public void theUserClickModule(String module) {
        new NewGroupContactsPage().navigateTo(module);
        BrowserUtils.waitFor(5);


    }

    @Then("the user on the contacts page")
    public void theUserOnTheContactsPage() {

        Assert.assertTrue(Driver.get().getCurrentUrl().contains("contacts"));

    }

    @When("the user click plus button")
    public void theUserClickPlusButton() {
        new NewGroupContactsPage().plusButton.click();
        BrowserUtils.waitFor(4);
    }

    @Then("the user can see {string} text in the box")
    public void theUserCanSeeTextInTheBox(String text) {
        String actualText = new NewGroupContactsPage().newgroupText.getText();
        Assert.assertEquals(text, actualText);

    }

    @When("the user enter new group name in the box")
    public void theUserEnterNewGroupNameInTheBox() {
        new NewGroupContactsPage().newGroupTextBox.sendKeys("STAR" + Keys.ENTER);
        BrowserUtils.waitFor(2);

    }

    @And("the user click All contacts button")
    public void theUserClickAllContactsButton() {
        new NewGroupContactsPage().allContactsButton.click();
    }

    @And("the user click contact")
    public void theUserClickContact() {
        new NewGroupContactsPage().contact.click();
    }




    @And("the user click groups dropdown menu")
    public void theUserClickGroupsDropdownMenu() {
        NewGroupContactsPage ngcp = new NewGroupContactsPage();
       ngcp.groupDropdown.click();
        BrowserUtils.waitFor(10);
    }

    @Then("the user can see {string}")
    public void theUserCanSee(String groupName) {

        NewGroupContactsPage ngcp = new NewGroupContactsPage();
        ngcp.starOption.click();
        BrowserUtils.waitFor(4);
        String actual=ngcp.groupDropdownList.get(0).getText();
        Assert.assertTrue(actual.contains(groupName));

    }
    @When("the user click Choose property type box")
    public void theUserClickChoosePropertyTypeBox() {
        new NewGroupContactsPage().propertyType.click();
        BrowserUtils.waitFor(5);
    }

    @And("the user select {string}")
    public void theUserSelectBirthday(String prop) {
        BrowserUtils.waitFor(10);
        new NewGroupContactsPage().setProperty(prop).click();

    }

    @Then("the user can see {string} box")
    public void theUserCanSeeBirthdayBox(String prop) {
        BrowserUtils.waitFor(10);
        Assert.assertTrue(new NewGroupContactsPage().getProperty(prop).isDisplayed());


    }


    @Then("the user see left side group names and should be matching with Groups dropdown menu")
    public void theUserSeeLeftSideGroupNamesAndShouldBeMatchingWithGroupsDropdownMenu() {
        NewGroupContactsPage ngcp=new NewGroupContactsPage();
        String leftSide=ngcp.leftGroupTable.getText();
        String rightSide=ngcp.groupDropdownList.get(0).getText();
        System.out.println("leftSide = " + leftSide);
        System.out.println("rightSide = " + rightSide);
        Assert.assertEquals(leftSide,rightSide);

    }
}
