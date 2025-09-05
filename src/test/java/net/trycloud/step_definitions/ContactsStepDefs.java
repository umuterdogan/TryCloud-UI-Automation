package net.trycloud.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.ContactsPage;
import org.junit.Assert;




public class ContactsStepDefs {


    ContactsPage contactsPage = new ContactsPage();

    @Given("the user clicks on {string} module")
    public void the_user_clicks_on_module(String module) {

        contactsPage.navigateTo(module);

    }

    @When("the user clicks on New Contact button")
    public void the_user_clicks_on_New_Contact_button() {

        contactsPage.newContactBtn.click();

    }

    @Then("the user can put {string}")
    public void the_user_can_put_and(String contact) {

        contactsPage.contactFullName.clear();
        contactsPage.contactFullName.sendKeys(contact);

    }

    @When("the user clicks on All contacts button")
    public void the_user_clicks_on_All_contacts_button() {

        contactsPage.allContactsBtn.click();

    }

    @Then("the user should see the {string} in the All contacts list")
    public void the_user_should_see_the_initials_in_the_All_contacts_list(String expectedInitials) {


        System.out.println(ContactsPage.listOfAllContacts());

        System.out.println("expectedInitials = " + expectedInitials);

        Assert.assertTrue(ContactsPage.listOfAllContacts().contains(expectedInitials));


    }


    @Then("the user should see total number of contacts")
    public void the_user_should_see_total_number_of_contacts() {

        int actualContactNum = ContactsPage.listOfAllContacts().size();
        System.out.println("actualContactNum = " + actualContactNum);

        int expectedContactNum = Integer.parseInt(contactsPage.contactTotalNum.getText());
        System.out.println("expectedContactNum = " + expectedContactNum);

        Assert.assertEquals(expectedContactNum, actualContactNum);

    }

    @When("the user clicks on an existing contact")
    public void the_user_clicks_on_an_existing_contact() {

        contactsPage.contactAvatar.click();

    }

    @When("the user clicks on the avatar icon on the right side")
    public void the_user_clicks_on_the_avatar_icon_on_the_right_side() {

        contactsPage.avatarMenuOptions.click();

    }

    @Then("the user clicks on Choose from files option")
    public void the_user_clicks_on_Choose_from_files_option() {

        contactsPage.chooseFromFiles.click();


    }

    @Then("the user should be able to change the profile picture")
    public void the_user_should_be_able_to_change_the_profile_picture() {

        contactsPage.pictureFile.click();

        contactsPage.chooseButton.click();

        Assert.assertTrue(contactsPage.contactAvatar.isEnabled());
    }


    @When("the user selects any {string} on the middle column")
    public void the_user_selects_any_on_the_middle_column(String contact) {

        int indexOfChosenContact = ContactsPage.listOfAllContacts().indexOf(contact);
        System.out.println("indexOfChosenContact = " + indexOfChosenContact);

        String chosenContact = ContactsPage.listOfAllContactsWebelements().get(indexOfChosenContact).getText();
        System.out.println("chosenContact = " + chosenContact);

        ContactsPage.listOfAllContactsWebelements().get(indexOfChosenContact).click();

    }

    @When("the user clicks on Delete option from the three dotted menu")
    public void the_user_clicks_on_Delete_option_from_the_three_dotted_menu() {

        contactsPage.threeDotMenu.click();

        contactsPage.deleteOption.click();

    }

    @Then("the user should be able to delete the {string}")
    public void the_user_should_be_able_to_delete_the_contact(String contact) {

        System.out.println("Deleted contact = " + contact);

        Assert.assertFalse(ContactsPage.listOfAllContacts().contains(contact));

        System.out.println("ContactsPage.listOfAllContacts() = " + ContactsPage.listOfAllContacts());


    }

    @And("the user {string} should be deleted after test")
    public void theUserShouldBeDeletedAfterTest(String name) {
        contactsPage.getContact(name).click();
        contactsPage.contactMenu.click();
        contactsPage.deleteOption.click();
    }
}