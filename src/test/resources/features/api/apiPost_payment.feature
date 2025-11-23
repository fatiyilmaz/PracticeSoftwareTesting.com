@apiPostPayment
Feature: Checkout Payment API

  Background:
    Given user goes to the site "https://api.practicesoftwaretesting.com/"

  Scenario: Successful payment
    Given the user sends a POST request with valid payment data
    Then the API response status code must be successful
    And the paymentStatus should be "Payment was successful"