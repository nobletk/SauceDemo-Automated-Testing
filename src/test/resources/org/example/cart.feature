Feature: Cart page testing options

  Background:
    Given the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the login button is clicked
    And the React Burger Menu is clicked
    And the Reset App State is clicked
    And the page is refreshed

  Scenario: Adding 2 items and removing 1 of them and checking cart badge number
    Given the Sauce Labs Backpack is added to the cart
    And the Sauce Labs Bolt T-Shirt is added to the cart
    When the Sauce Labs Backpack is removed from the cart
    Then the number '1' should be showing on top of the shopping cart badge

