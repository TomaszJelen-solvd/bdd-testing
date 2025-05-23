Feature: Testing if User orders are properly processed

  Scenario: User 1 order is correctly processed
    Given I have 1 user data
    And I am on login page
    When I perform login
    And I add products to cart from list
    And I enter cart
    And I checkout cart
    And I perform checkout
    Then All products form list are in overview

  Scenario: User 2 order is correctly processed
    Given I have 2 user data
    And I am on login page
    When I perform login
    And I add products to cart from list
    And I enter cart
    And I checkout cart
    And I perform checkout
    Then All products form list are in overview