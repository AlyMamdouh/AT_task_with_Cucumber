@Searching

Feature: Search for a Customer

  Scenario: Successfully search for an existing customer
    Given the user is navigated to XYZ Bank Page and logged in as bank manager ForTC03
    And the user creates a new customer ForTC03
    Then the user go to home and clicks the Customers button ForTC03
    Then the user searches for the customer by name
    Then the customer should be found in the search results
