package net.trycloud.step_definitions;

import io.cucumber.java.en.Then;
import net.trycloud.pages.ActivityPage;
import net.trycloud.utilities.BrowserUtils;
import net.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ActivityStepDefs {
    ActivityPage page = new ActivityPage();
    @Then("User verifies all categories exist in Activity module")
    public void userVerifiesAllCategoriesExistInActivityModule(List <String> expectedCategories) {
        List<String> actualCategories = BrowserUtils.getElementsText(page.allActivityCategories);
        Assert.assertEquals("Categories are NOT same",expectedCategories,actualCategories);
    }

    @Then("User verifies all items list ordered by newest to oldest")
    public void userVerifiesAllItemsListOrderedByNewestToOldest() {
        List<WebElement> activityDateObjectsList = page.activityDateObjects;
        List<LocalDateTime> datesOfActivities =  new ArrayList<>();

        // change activity dates and times to Java Local Date and Time object to be compared
        for (WebElement activityDateObject : activityDateObjectsList) {
          //   December 24, 2023 4:12 PM
            String[] arr = activityDateObject.getAttribute("data-original-title").split(" ");
            Month month = Month.valueOf(arr[0].toUpperCase());
            int year = Integer.parseInt(arr[2]);
            int dayOfMonth = Integer.parseInt(arr[1].substring(0,arr[1].indexOf(",")));
            int hour = Integer.parseInt(arr[3].substring(0,arr[3].indexOf(":")));
            int minute = Integer.parseInt(arr[3].substring(arr[3].indexOf(":")+1));
            datesOfActivities.add(LocalDateTime.of(year,month,dayOfMonth,hour,minute));
        }

        // verify that dates are ordered
        for (int i = 0; i < datesOfActivities.size()-1; i++) {
            Assert.assertTrue(datesOfActivities.get(i).compareTo(datesOfActivities.get(i+1)) >= 0); // last activity date is either after or around same time
        }

    }


    @Then("User verifies that {string} message is visible")
    public void userVerifiesThatMessageIsVisbile(String expectedMessage) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        BrowserUtils.sleep(2);

        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }

       Assert.assertTrue(page.noMoreElement.getAttribute("outerHTML").contains(expectedMessage));
    }
}
