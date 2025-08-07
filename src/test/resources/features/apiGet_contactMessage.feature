@getMessage
Feature: Get Message

  Background:
    Given user goes to the site "https://api.practicesoftwaretesting.com/"


  @apiGetAllMessage
  Scenario: Get ALL MESSAGE
    And Messages sent in the contact area
    Then Successfully created messages are verified


  @apiGetCreatedMessage
  Scenario: Get CREATED MESSAGE
    And The created message is retrieved
    Then The correct creation of the message created by the user is verified