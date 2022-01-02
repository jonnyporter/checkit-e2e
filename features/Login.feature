Feature: Test the login functionality

  Scenario: The user should be able to login
    Given the user goes to login page
    When the user logs in
    Then the user lands on home page

  Scenario: The user should see an error message when entering invalid credentials
    Given the user goes to login page
    When the user enters invalid credentials
    Then the user sees an error message

  Scenario: The user should be able to logout
    Given the user is logged in
    When the user logs out
    Then the user lands on the login page