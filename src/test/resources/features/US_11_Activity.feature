Feature: Activity Module

  Background:
    Given the user is logged in
    And   the user navigate to "Activity" module

  Scenario:  Verify that user can display all listed items under the Activity module.
    Then User verifies all categories exist in Activity module
    |All activities |
    |By you         |
    |By others      |
    |Circles        |
    |Favorites      |
    |File changes   |
    |File shares    |
    |Calendar       |
    |Todos          |
    |Comments       |
    |Deck           |

  Scenario:  Verify that user can see all items list ordered by newest to oldest
    Then User verifies all items list ordered by newest to oldest

  Scenario:  User can see "No more events to load" message at the end of the "All Activities" tab.
    Then User verifies that "No more events to load" message is visible