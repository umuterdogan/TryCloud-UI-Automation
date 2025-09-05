Feature: Notes Module

  Background:
    Given the user is logged in
    When the user click "Notes" module

  Scenario Outline: Verify user can create a new note

    And the user click New Note
    And the user write "<notes>"
    Then note title should match with first words of "<notes>"
    And the user click three dot on "<notes>" title
    And the user clicks on delete button

    Examples:
      | notes                   |
      | you are a perfect SDET! |


  Scenario Outline: User can add any note to the favorites
    And the user click New Note
    And the user write "<notes>"
    And the user click three dot on "<notes>" title
    And the user click add to favorite tab
    And the user navigate to "Files" module
    And the user navigates to favorites tab
    Then the user should see "<notes>" as favorites
    And the user click "Notes" module
    And the user click three dot on "<notes>" title
    And the user clicks on delete button
    Examples:
      | notes              |
      | sample text for AC |


  Scenario Outline: User can see the number of letters and words that the note includes under the note title when clicked on the details of the note
    And the user click New Note
    And the user write "<notes>"
    And the user clicks three dot icon on note page
    And the user clicks on Details
    Then the user should see notes details
    And the user click three dot on "<notes>" title
    And the user clicks on delete button
    Examples:
      | notes                   |
      | you are a perfect SDET! |


  Scenario Outline: User can create a new category by passing a new category name from inside the notes details
    And the user click New Note
    And the user write "<notes>"
    And the user clicks three dot icon on note page
    And the user clicks on Details
    And the user enter category "<name>"
    And the user clicks on categories tab
    Then the user should see the category "<name>"
    And the user click three dot on "<notes>" title
    And the user clicks on delete button
    Examples:
      | name              | notes             |
      | New Test Category | You are the best! |


  Scenario Outline: User can delete any note
    And the user click New Note
    And the user write "<notes>"
    And the user click three dot on "<notes>" title
    And the user clicks on delete button
    Then the user should see deletion message
    Examples:
      | notes                |
      | Sample note for Test |
