#User Story :
#As a user I should be able to modify Dashboard page
#Acceptance Criteria
#1 - After Login user can see all modules and Username.
#2 - User can click on Customize button and select any of the Widgets.
#3 - User can click on Set Status button and select any of the Status options.

@wip
Feature: Dashboard Functions

  Background:
    Given the user is logged in

  @smoke
  Scenario: After Login user can see all modules and Username
    Then the user should be able to see the username
    And the user should be able to see below modules
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |
      | More      |


  Scenario: User can click on Customize button and select any of the Widgets
    When user click "customize button"
    Then the "widgets" are clickable


    Scenario: User can click on Set Status button and select any of the Status options
      When user click "user icon"
      And user click "status"
      Then the "status" are clickable