Feature: Profile Settings Functionality

  Background:
    Given the user is logged in
    And the user clicks the avatar icon
    And the user clicks settings label

  Scenario: User can see at least following titles inside personal info under Full name/Email/Phone Number
    Then the user should see following labels
      | Full name       |
      | Email           |
      | Phone number    |
      | Address         |
      | Website         |
      | Twitter         |
      | Language        |
      | Locale          |
      | Profile picture |


   Scenario: User can change "Full name" info under Profile Settings page
     And the user enters the name "Abcd"
     Then the user should be able to see the "Abcd"

  Scenario: User can make "Phone number" info as private under Profile Settings page
    And the user clicks the phone icon-triangle
    And the user clicks the private label
    Then the user should see the private is selected


  Scenario: User can see the current local time under the Local dropdown
    Then the user should see the localtime in page




