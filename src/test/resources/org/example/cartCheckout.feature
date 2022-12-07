Feature: Ordering and checking out

  Background:
    Given the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the login button is clicked
    And the React Burger Menu is clicked
    And the Reset App State is clicked
    And the page is refreshed


  Scenario: Buying one item and checking the total price
    Given the Sauce Labs Backpack is added to the cart
    And the cart icon is clicked
    And the Checkout button is clicked
    And the First name is filled with 'A'
    And the Last name is filled with 'B'
    And the Zip code is filled with '1234'
    When the Continue button is clicked
    Then 'Total: $32.39' should be shown as total price

  Scenario: Buying 3 items and checking
    Given the Sauce Labs Backpack is added to the cart
    And the Sauce Labs Bolt T-Shirt is added to the cart
    And the Sauce Labs Bike Light is added to the cart
    And the cart icon is clicked
    And the Checkout button is clicked
    And the First name is filled with 'A'
    And the Last name is filled with 'B'
    And the Zip code is filled with '1234'
    When the Continue button is clicked
    Then 'Total: $60.45' should be shown as total price
    And  'Tax: $4.48' should be shown as tax
    And 'Item total: $55.97' should be shown as an item total
