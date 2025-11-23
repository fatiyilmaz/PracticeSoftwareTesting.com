@apiSignandlogin
Feature: Api Testing

  Background:
    Given user goes to the site "https://api.practicesoftwaretesting.com/"

  @apiPostRegister
  Scenario: POST REGISTER
    And post makes the process
    Then response verifies

  @apiPostLogin
  Scenario: POST LOGIN
    And user should be able to log in with the information they registered with
    Then user verifies that they are logged in

