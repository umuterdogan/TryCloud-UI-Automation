Feature: Profile Settings Functionality Second Feature

  Background:
    Given the user is logged in
    And the user clicks the avatar icon
    And the user clicks settings label

  Scenario: Verify that full name and username are the same
    Then User verifies that logged in user and profile user has same full name

  Scenario: User can enter a proper e-mail to Email input box
    When User enters invalid format email "testexample.com" to settings
    Then Verifies email value is empty
    When User enters valid format email "test@example.com" to settings
    Then Verifies email value is changed accordingly

    Scenario: User can change Language
      When User changes the language to "Türkçe"
      Then Verifies language box label changed as "Dil"
      And User changes the language to "English (US)"
