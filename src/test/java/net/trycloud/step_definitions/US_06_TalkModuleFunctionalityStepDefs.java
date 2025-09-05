package net.trycloud.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.*;
import net.trycloud.utilities.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class US_06_TalkModuleFunctionalityStepDefs {

    TalkPage talkPage = new TalkPage();

    @When("user enter {string} as Conversation name")
    public void user_enter_as_conversation_name(String string) {
        talkPage.conversationNameInput.sendKeys(string);
    }
    @When("user select a user from the list")
    public void user_select_a_user_from_the_list() {
        Random random = new Random();
        int index = random.nextInt(talkPage.participantList.size());
        talkPage.participantList.get(index).click();
    }

    @When("user delete conversation {string}")
    public void user_delete_conversation(String conversationName) {
        WebElement dropdown = Driver.get().findElement(By.xpath("//span[normalize-space(text())='" + conversationName + "']/../../../following-sibling::div//button"));
        dropdown.click();
        talkPage.deleteConversationBtn.click();
        BrowserUtils.waitFor(3);
        talkPage.yesBtn.click();

    }
    @Then("the conversation should be deleted.")
    public void the_conversation_should_be_deleted() {
        Assert.assertTrue(talkPage.testConversation.isEnabled());
    }
}
