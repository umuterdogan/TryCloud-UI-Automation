Feature: Contacts Module

  Background:
    Given the user is logged in
    And the user clicks on "Contacts" module


  Scenario Outline: User can create a new contact
    When the user clicks on New Contact button
    Then the user can put "<Contact_Name>"
    When the user clicks on All contacts button
    Then the user should see the "<Contact_Name>" in the All contacts list
    And the user "<Contact_Name>" should be deleted after test

    Examples:
      | Contact_Name |
      | Oscar Test   |

    # we create then delete the user to keep our database clean


  Scenario: User can see all the contacts as a list inside the middle column and total number
    When the user clicks on All contacts button
    Then the user should see total number of contacts


  Scenario: User can change the profile picture of any contact by using “Choose from files” option
    When the user clicks on an existing contact
    And the user clicks on the avatar icon on the right side
    Then the user clicks on Choose from files option
    And the user should be able to change the profile picture

    # For this scenario you need to have a jpg/jpeg file in the system of files otherwise the test fails


  Scenario Outline: User can delete any selected contact
    When the user selects any "<contact>" on the middle column
    And the user clicks on Delete option from the three dotted menu
    Then the user should be able to delete the "<contact>"

    Examples:
      | contact    |
      | TestName   |

    # This scenario can be either run together with creating a new contact, or delete a manually created contact


