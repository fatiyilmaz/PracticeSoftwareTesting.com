@postMessage
Feature: Post Message

  Background:
    Given user goes to the site "https://api.practicesoftwaretesting.com/"

  Scenario: POST MESSAGE
    Given Creates a message
    Then The message is verified