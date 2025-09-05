Feature: Log out Function

  Background: Preconditions
    Given the user is logged in
    And the user clicks the avatar icon
    And the user clicks the logout label

  Scenario: User can log out and ends up in login page
   Then the user should see the url contains "/index.php/login"


  Scenario: User can not go to home page again by clicking step back button after successfully logged out.
    Then the user should see the url contains "/index.php/login"
    When the user clicks step back button
    Then the user should see the url contains "/index.php/login"

