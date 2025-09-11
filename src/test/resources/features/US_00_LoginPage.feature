Feature: As a user, I should be able to log in.

  @smoke
  Scenario Outline: User can login with valid credentials (either clicking on the "Login button" or hitting the
  "Enter" key from the keyboard as the last step)
    Given the user on the login page
    Given the user is logged in with "<submitType>"
    Then  the user should see the url contains "index.php/apps/dashboard/"
    And the user should see the username as "Employee61"
    Examples:
      | submitType |
      #| submitButton |
      | enterKey   |


  # @smoke
  Scenario Outline: User cannot login with any invalid credentials "Wrong username or password." should be displayed
  for invalid credentials
    Given the user on the login page
    And the user is logged in "<username>" and "<password>" with "<submitType>"
    Then the user should see the message "Wrong username or password."
    Then the user should see the url contains "index.php/login"

    Examples:
      | username   | password    | submitType   |
      | 1234       | Employee123 | submitButton |
    #  | 1234       | 1234        | submitButton |
     # | Employee61 | 1234        | submitButton |
      | 1234       | Employee123 | enterKey     |
     # | 1234       | 1234        | enterKey     |
     # | Employee61 | 1234        | enterKey     |


  @NegativeLogin
  Scenario Outline: 2-User cannot login with any invalid credentials "Please fill out this field" message should be
  displayed if the password or username is empty
    Given the user on the login page
    And the user is logged in "<username>" and "<password>" with "<submitType>"
    Then the user should see the message "Please fill out this field."
    And the user should see the url contains "index.php/login"

    Examples:
      | username   | password   | submitType   |
      |            | Emploee123 | submitButton |
     # | Employee61 |            | submitButton |
     # |            |            | submitButton |
     # |            | Emploee123 | enterKey     |
     # | Employee61 |            | enterKey     |
     # |            |            | enterKey     |



  Scenario: User can see the password in a form of dots by default
    Given the user on the login page
    And the user enters the password
    Then the user should see the password form of dots


  Scenario: User can see the password explicitly if needed
    Given the user on the login page
    And the user enters the password
    And the user clicks the toggle button
    Then the user  should see the password explicitly


  Scenario: User can see the "Forgot password?" link on the login page and can see the "Reset Password" button on the next page after clicking on forget password link
    Given the user on the login page
    Then the user should see the forgot password link
    When the user clicks the forgot password link
    Then the user should see the "Reset password" button


  Scenario Outline: : User can see valid placeholders on Username and Password fields
    Given the user on the login page
    Then the user should see the "<value>" as placeholder for "<textBoxType>" textbox

    Examples:
      | value             | textBoxType |
     # | Password          | password    |
      | Username or email | username    |
