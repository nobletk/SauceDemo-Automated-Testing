Feature: Sorting products

  Background:
    Given the homepage is open
    And the Username is filled with 'standard_user'
    And the Password is filled with 'secret_sauce'
    And the login button is clicked

  Scenario: Sorting products by name (Z to A)
    Given the Product Sort Button is clicked
    When the Name (Z to A) is clicked
    Then the Reverse Alphabetical order is shown

  Scenario:  Sorting products by Price (low to high)
    Given the Product Sort Button is clicked
    When the Price (low to high) is clicked
    Then the Product list is sorted by price from low to high

