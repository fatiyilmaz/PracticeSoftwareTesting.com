@api_categories
Feature: GET all categories and verify response

  Background:
    Given user goes to the site "https://api.practicesoftwaretesting.com/"

  @apiGetCategories
  Scenario: All Categories
    And The categories on the page are visible.
    Then All parent and child categories are confirmed to have arrived successfully with a 200 status code


  @apiGetCategoriesSpesificId
  Scenario: Get product list with valid category id
    When the request contains categoryId "01KCEJJRWDS83V0SVW4BJXNVGX" and send a GET request
    Then the response status code should be 200
    And the response should contain product list
    And all products should have categoryId "01KCEJJRWDS83V0SVW4BJXNVGX"


  @apiGetCategoriesInvalidId
  Scenario: Get products with invalid category id
    When the request contains categoryId "99999" and send a GET requestt
    Then the response status code should bee 404
    And the response message should be "Requested item not found"
