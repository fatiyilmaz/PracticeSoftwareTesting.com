@api_products
Feature: Get all products

  Background:
    Given user goes to the site "https://api.practicesoftwaretesting.com/"

  @apiGetProducts
  Scenario: Products
    And user sends a GET request to retrieve all products
    Then verify that the products are listed and response is successful