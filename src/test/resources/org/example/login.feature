Feature: Login page test

  Background:
    Given the homepage is open

  Scenario Outline: Accepted login credentials
    Given the Username is filled with '<users>'
    And the Password is filled with '<passwords>'
    When the login button is clicked

    Examples:
      | users  | passwords |
      |  standard_user | secret_sauce |

  Scenario Outline: Missing Username field
    Given the Username is filled with '<users>'
    And the Password is filled with '<passwords>'
    When the login button is clicked
    Then the '<msg>' error message is shown
    Examples:
      | users | passwords | msg |
      |                | secret_sauce | Epic sadface: Username is required |

  Scenario Outline: Missing password field
    Given the Username is filled with '<users>'
    And the Password is filled with '<passwords>'
    When the login button is clicked
    Then the '<msg>' error message is shown

    Examples:
      | users  | passwords | msg |
      |  standard_user |           | Epic sadface: Password is required |

  Scenario Outline: Locked out user credentials
    Given the Username is filled with '<users>'
    And the Password is filled with '<passwords>'
    When the login button is clicked
    Then the '<msg>' error message is shown
    Examples:
      | users | passwords | msg |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |

  Scenario Outline: Unaccepted login credentials
    Given the Username is filled with '<users>'
    And the Password is filled with '<passwords>'
    When the login button is clicked
    Then the '<msg>' error message is shown

    Examples:
      | users  | passwords | msg |
      | something | something_else | Epic sadface: Username and password do not match any user in this service|