Feature: Add to Favorites/Rename/Comment on File Functionality

  Background:
    Given the user is logged in
    When the user navigate to "Files"

  Scenario: User can add any file to favorites from its own three dots menu
    When the user upload "testTXTFile.txt"
    When the user clicks on "testTXTFile.txt" add to favorites under its own three dots menu
    And the user navigates to favorites tab
    Then the user can verify that "testTXTFile" has been added under the favorites tab
    And the user navigate to "Files"
    And the user delete any selected "testTXTFile.txt"

  Scenario: User can rename any file from its own three dots menu
    When the user upload "testTXTFile.txt"
    When the user clicks on "testTXTFile.txt" rename under its own three dots menu
    And the user renames the file as "reNamedFile"
    Then the user can verify that the file has been renamed as "reNamedFile"
    And the user delete any selected "reNamedFile.txt"

  Scenario: User can put some comments on any file from the file details menu opened right side
    When the user clicks on an existing file's details from its own three dots menu
    And the user navigates to comments tab
    And put some comments
    Then the user can verify that comment has been added

  Scenario: User can delete the comments made on any file from the the file details menu opened right side
    When the user clicks on an existing file's details from its own three dots menu
    And the user navigates to comments tab
    And click on any comment's own three dot menu and select delete
    Then the user can verify that comment has been deleted