Feature: Add a new customer

  Scenario: Successfully add a new customer
    Given the user is navigated to XYZ Bank Page and logged in as bank manager ForTC01
    When the user clicks on the Add Customer button
    And fills in the customer details and clicks on the Add Customer button
    Then a success message should be displayed
