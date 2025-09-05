@haden
Feature: Deck Module Functionality

#  The scenarios inside this Feature file, shouldn't be run seperately (except the first one)
#  Otherwise, it is inevitable to get failed results
#  The scenarios are linked to the previous one

  Background:
    Given the user is logged in
    And the user clicks on "Deck" module


  Scenario Outline: User can create a new Board

    When the user clicks on Add board button
    And the user enters a "<Board Name>"
    And the user clicks on the arrow button
    Then the user should see the new "<Board Name>" under All boards

    Examples:
      | Board Name |
      | TestBoard  |


  Scenario Outline: User can create a new list under an existing Board

    When the user clicks on an existing Board Name
    And the user clicks on Add list button
    And the user enters the name of the "<new list name>"
    And the user clicks on the Submittance Arrow button
    Then the "<new list name>" should be seen under the selected Board Name

    Examples:
      | new list name |
      | TestList      |


  Scenario Outline: User can create a new card under an existing list

    When the user clicks on an existing Board Name
    And the user clicks on the plus button to Add card
    And the user enters the "<new Card Name>"
    And the user clicks on the Confirmation Arrow
    Then the "<new Card Name>" should be seen under the list and the right side

    Examples:
      | new Card Name |
      | TestCard      |


  Scenario: User can assign any card to himself/herself

    When the user clicks on an existing Board Name
    And the user clicks on three dot button inside an existing card
    And the user clicks on Assign to me option inside the popover menu
    Then the user should be able to see the user profile icon next to the three dots icon



#  This scenario will delete the last created Board in order not to create the new boards with the same name
  Scenario: Delete the last created Board

    When the user clicks on an existing Board Name
    And the user clicks on the three dot icon next to the selected Board
    Then the user clicks on Delete Board option inside the popover menu



















