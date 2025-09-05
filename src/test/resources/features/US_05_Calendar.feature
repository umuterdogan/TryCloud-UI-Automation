Feature: Calendar Module

  Background:
    Given the user is logged in
    And   the user navigate to "Calendar" module

  Scenario: Daily calendar view
    Given the user click three dot icon
    When  the user click day icon
    Then  the user can see daily calendar view

  Scenario: Weekly calendar view
    Given the user click three dot icon
    When  the user click week icon
    Then  the user can see weekly calendar view

  Scenario: Monthly calendar view
    Given the user click three dot icon
    When  the user click monthly icon
    Then  the user can see monthly calendar view

  Scenario: Create new event
    Given the user click new event
    When  the user can give a name "Agile Meeting" for new event
    When  the user can choose today's date as event start date
    When  the user can choose today's date as event finish date
    Then  the user can click save event button
    Then  the user can see new event related day on the monthly calendar view

  Scenario: Delete new event
    When  the user can click event "Agile Meeting" on monthly calendar
    When  the user can click more button
    Then  the user can click three button next to event's name
    Then  the user can click delete button

    # creating and deleting event scenarios should be run one after another. creating and deleting same event