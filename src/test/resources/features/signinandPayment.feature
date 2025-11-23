@Payment
Feature: Payment Testing

  Background:
    Given Homepage login
    And Verify homepage

  Scenario: The user logs in and purchases the product.
    Given A product is randomly selected from the homepage
    And Click the Add to Cart button
    And Click on the cart to purchase the added product
    And They see the product they selected in the cart
    And Click the Proceed to Checkout button
    And The session account is verified. You are prompted to proceed to the payment screen
    And The Billing Address fields appear to be filled in, and you can proceed
    And Bank transfer payment method is selected
    And Enter the bank name
    And Enter account name
    And Enter account number
    Then Payment successfully verified


  Scenario: Checkout Payment API
    Given user has a valid authentication token
    Given user sends POST request to "/payment/check" with valid payment data
    Then the API response status code should be 200
    And the paymentStatus should be "Payment was successful"