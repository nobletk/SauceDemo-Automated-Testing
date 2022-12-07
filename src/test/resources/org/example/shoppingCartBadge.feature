Feature: Testing the shopping cart badge number

  Background:
    Given  the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the login button is clicked
    And the React Burger Menu is clicked
    And the Reset App State is clicked
    And the page is refreshed

  Scenario: two items
    Given the Sauce Labs Backpack is added to the cart
    And the Sauce Labs Bike Light is added to the cart
    Then the number '2' should be showing on top of the shopping cart badge

  Scenario: three items
    Given the Sauce Labs Backpack is added to the cart
    And the Sauce Labs Bike Light is added to the cart
    And the Sauce Labs Bolt T-Shirt is added to the cart
    Then the number '3' should be showing on top of the shopping cart badge

