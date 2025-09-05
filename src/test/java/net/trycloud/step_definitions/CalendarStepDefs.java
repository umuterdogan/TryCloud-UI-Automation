package net.trycloud.step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.CalendarPage;
import net.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Date;
import java.util.List;

public class CalendarStepDefs {
    Date date = new Date();
    CalendarPage calendarPage=new CalendarPage();
    Actions actions = new Actions(Driver.get());

    String eventName;

    @Given("the user navigate to {string} module")
    public void the_user_navigate_to_module(String module) {

        calendarPage.navigateTo(module);
    }

    @Given("the user click three dot icon")
    public void the_user_click_three_dot_icon() {

        calendarPage.threeDotIcon.click();
    }

    @When("the user click day icon")
    public void the_user_click_day_icon() {

        calendarPage.dayButton.click();
    }

    @Then("the user can see daily calendar view")
    public void the_user_can_see_daily_calendar_view() {

       String actualresult= calendarPage.datePickerButton.getText();
       String todaysDate = actualresult.substring(0,actualresult.indexOf(","));

        System.out.println(todaysDate);
        System.out.println(date.toString());

     Assert.assertTrue(date.toString().contains(todaysDate));
    }

    @When("the user click week icon")
    public void the_user_click_week_icon() {

        calendarPage.weekButton.click();
    }

    @Then("the user can see weekly calendar view")
    public void the_user_can_see_weekly_calendar_view() {

        List<WebElement> weeklyWievList = calendarPage.weeklyWievList;

        for (WebElement webElement : weeklyWievList) {
            System.out.println(webElement.getText());
        }

      Assert.assertEquals(8, weeklyWievList.size());
    }

    @When("the user click monthly icon")
    public void the_user_click_monthly_icon() {

        calendarPage.monthButton.click();
    }

    @Then("the user can see monthly calendar view")
    public void the_user_can_see_monthly_calendar_view() {

        String actualresult= calendarPage.datePickerButton.getText();

        // getting local date and converting to the data we need
        String year = "20"+Integer.toString(date.getYear()).substring(1);
        String expectedresult=new CalendarPage().getMonth(date.getMonth())+" "+year;

        Assert.assertEquals(actualresult,expectedresult);
    }

    @Given("the user click new event")
    public void the_user_click_new_event() {

        calendarPage.newEventButton.click();
    }

    @When("the user can give a name {string} for new event")
    public void the_user_can_give_a_name_for_new_event(String eventName) {
        this.eventName = eventName;
        calendarPage.eventName.sendKeys(eventName);
    }

    @When("the user can choose today's date as event start date")
    public void the_user_can_choose_today_s_date_as_event_start_date() {

        // getting today's date and time setting as starting
        actions.click(calendarPage.startDateAndTime).sendKeys(date.toString()).perform();

    }

    @When("the user can choose today's date as event finish date")
    public void the_user_can_choose_today_s_date_as_event_finish_date() {
        // adding one hour to today's time and date, setting ending time
        date.setTime(date.getTime()+(3600000));
        actions.click(calendarPage.endDateAndTime).sendKeys(date.toString()).perform();

    }

    @Then("the user can click save event button")
    public void the_user_can_click_save_event_button() {
        calendarPage.saveButton.click();
    }

    @Then("the user can see new event related day on the monthly calendar view")
    public void the_user_can_see_new_event_related_day_on_the_monthly_calendar_view() {

       Assert.assertTrue(calendarPage.verifyEvent(eventName).isDisplayed());

    }

    @When("the user can click event {string} on monthly calendar")
    public void the_user_can_click_event_on_monthly_calendar(String eventName) {

        calendarPage.verifyEvent(eventName).click();

    }

    @When("the user can click more button")
    public void the_user_can_click_more_button() {

        calendarPage.moreButton.click();

    }

    @Then("the user can click three button next to event's name")
    public void the_user_can_click_three_button_next_to_event_s_name() {

        calendarPage.actionButton.click();

    }

    @Then("the user can click delete button")
    public void the_user_can_click_delete_button() {

        calendarPage.deleteButton.click();

    }


}
