@OpeningAcc

Feature: Open an Account

  Scenario: Successfully open an account for a created customer
    Given the user is navigated to XYZ Bank Page and logged in as bank manager ForTC02
    And the user creates a new customer ForTC02
    Then the user go to home and opening new account
    Then the user can log in with the new account
