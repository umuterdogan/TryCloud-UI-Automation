#User Story :
#As a user, I should be able to create a new conversation, add participant under the Talk module
#Acceptance Criteria:
#1. User can create a new conversation by adding any selected participant
#2. User can delete a conversation

Feature: As a user, I should be able to create a new conversation, add participant under the Talk module

  Background:
    Given the user is logged in
    And the user clicks on "Spreed" module


  Scenario: User can create a new conversation by adding any selected participant
    When user click "Create a new group conversation"
    And user enter "Test" as Conversation name
    And user click "Add participants"
    And user select a user from the list
    And user click "Create conversation"
    Then the user should see the message "You created the conversation"


  Scenario: User can delete a conversation
    When user delete conversation "Test"
    Then the conversation should be deleted.
