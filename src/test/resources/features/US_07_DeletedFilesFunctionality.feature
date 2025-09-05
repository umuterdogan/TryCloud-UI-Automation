Feature: Deleted Files Tab Functionality
  Background:
    Given the user on the login page
    Given the user is logged in
    And the user navigate to "files"
    When the user clicks Deleted files link

  Scenario: User can order the all deleted files by newest to oldest or visa versa
    And the user deletes the file which is in the first line
    When the user clicks Deleted files link
    Then the user should be able to order the all deleted files


  Scenario: User can order alphabetically all the deleted files based on their names
    When the user clicks Deleted files link
    Then the user should be able to order alphabetically all the deleted files


  Scenario: User can delete any deleted file permenantly by using the three dots icon in the file’s line
    Then the user should be able to delete any deleted file permanently

  Scenario: User can restore any deleted file and see it again under the All Files tab
    When the user clicks Deleted files link
    Then he user should be able to restore the file