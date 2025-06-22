@signandlogin
Feature: Sign in and Log in Testing

  Background:
    Given Homepage login
    And Verify homepage

  @register
  Scenario: Positive Register Testing
    Given Sees sign in and clicks
    And Clicks Register your account because your does not have an account
    And Sees that you are on the Register page
    And Enters a string value in the First name box
    And Enters a string value in the Last name box
    And Selects date from Date of birth field
    And Enters string and valid value in the Street box
    And Enters valid value in Postal code
    And Enters string value in the City box
    And Enters string in the State box
    And Selects a country from the country field
    And Enters valid value in the phone box
    And Enters string and valid value in Email box
    And The password box is filled in according to the criteria
    And Clicks on the Register box
    Then Should be redirected to the login page



  @login
  Scenario: Positive Login Testing
    Given Clicks sign in to log in
    And Sees that you are on the Login page
    And Enters string and valid value in the Email address box
    And Fill in the password box
    And Clicks on the Login box
    Then Verifies that you have successfully opened your account



