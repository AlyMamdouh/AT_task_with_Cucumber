Feature: Add a new customer

  Scenario: Successfully add a customer
    Given the browser is opened
    And the user navigates to the bank's homepage
    When the user logs in as bank manager
    And clicks the "Add Customer" button
    And enters the first name, last name, and postcode
    Then the customer should be added successfully
