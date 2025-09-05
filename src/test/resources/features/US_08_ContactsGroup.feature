Feature: New Group under Contact Module

  Background:
    Given the user is logged in
    When the user click "Contacts" module


Scenario: User can create a new group under Contacts Module
    Then the user on the contacts page
    When the user click plus button
    Then the user can see "Create a new group" text in the box
    When the user enter new group name in the box

Scenario: User can add "Groups" dropdown menu existing inside that specific contact’s own info menu
    Then the user on the contacts page
    When the user click plus button
    Then the user can see "Create a new group" text in the box
    When the user enter new group name in the box
    And the user click All contacts button
    And the user click contact
    And the user click groups dropdown menu
    Then the user can see "STAR"


  Scenario: User can see all the available groups name through the groups dropdown menu existing in the contact’s own info menu
    Then the user on the contacts page
    When the user click plus button
    Then the user can see "Create a new group" text in the box
    When the user enter new group name in the box
    And the user click All contacts button
    And the user click contact
    When the user click groups dropdown menu
    Then the user see left side group names and should be matching with Groups dropdown menu


  Scenario: User can add a new property as “Birthday”
    When the user click Choose property type box
    And the user select "Birthday"
    Then the user can see "Birthday" box
# can be changed with anniversary or other properties






