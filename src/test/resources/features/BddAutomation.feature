Feature: Testing if User orders are properly processed

  Scenario: User order is correctly processed
    Given I am on login page
    When I perform login
    And I add products to cart from list
    And I enter cart
    And I checkout cart
    And I perform checkout
    Then All products form list are in overview