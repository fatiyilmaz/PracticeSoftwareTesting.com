@homepage
Feature: Products Testing

  Background:
    Given Homepage login
    And Verify homepage

    @homepageProducts
    Scenario: Products
    Given Sees nine products on the homepage
    And Goes to page five and sees nine products on each page
    And Random clicks on a product and verifies that your has entered the product
    And Should be able to see more products in the related products section

   @Categories
   Scenario: Categories
   Given Must be able to see the Categories dropdown
   And Ability to see five different categories in the Categories tab
   Then Enters these categories and verifies that it is on the right page