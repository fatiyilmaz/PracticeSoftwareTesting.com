@contact
Feature: Contact

  Background:
    Given Homepage login
    And Verify homepage
    And Should be able to click on the Communication tab
    And Verify that you are on the right page


  @requiredFields
  Scenario: Do not proceed without filling in mandatory fields
    Given When you click submit without filling in the fields, you will see warning messages


  @subjectSelection
  Scenario Outline: Communicate by choosing any message subject
    Given Text should be able to be entered in the name box
    And Text should be able to be entered in the last name box
    And Email field must be fillable
    And Subject "<subject>" should be selectable
    And The message box must be fillable
    And The file should be selectable
    And The send box should be clickable
    Then See a warning message that the message has been successfully transmitted
    Examples:
      | subject            |
      | Customer service   |
      | Webmaster          |
      | Return             |
      | Payments           |
      | Warranty           |
      | Status of my order |


  @negativeFirstnameLastname
  Scenario Outline: Negative First Name - Last Name
    Given Text should be able to be entered in the name box "<name>"
    And Text should be able to be entered in the last name box "<lastname>"
    And Email field must be fillable
    And Subject should be selectable
    And The message box must be fillable
    And The file should be selectable
    And The send box should be clickable
    Then The user should be asked to enter at least three alphabetic characters, otherwise an error message should be displayed.
    Examples:
      | name | lastname |
      | a    | 1        |
      | 2    | b        |
      | 12   | *-       |
      | as   | _        |
      | .    | ,        |
