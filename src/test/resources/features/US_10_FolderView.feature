Feature: User Folder view functionality

  Background:the user is logged in
    Given the user is logged in
    And the user navigate to "files"

  Scenario: User can change the folder view

    When the user clicks on toggle view
    Then the order of the folders should change by view


  Scenario:

    When the user clicks on size
    Then the order of the folders should change by size

  Scenario:

    And the user clicks on name
    Then the view of folders should change by name


  Scenario:

    When the user clicks on modified
    Then the order of the folders should change by date


