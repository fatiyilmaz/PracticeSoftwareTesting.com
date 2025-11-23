@contactMessages
Feature: Get Message

  Background:
    Given user goes to the site "https://api.practicesoftwaretesting.com/"

  @apiGetAllMessage
  Scenario: Get ALL MESSAGE
    And user logs in with default credentials
    And Messages sent in the contact area
    Then Successfully created messages are verified

  @apiGetCreatedMessage
  Scenario: POST and GET Created MESSAGE
    Given Creates a message
    Then The message is verified
    And user logs in with default credentials
    And The created message is retrieved
    Then The correct creation of the message created by the user is verified