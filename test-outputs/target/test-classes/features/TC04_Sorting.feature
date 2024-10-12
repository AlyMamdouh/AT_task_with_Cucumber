@Sorting

Feature: Sorting Customers by Postcode

  Scenario: Successfully Sort Customers by Postcode
    Given the user is navigated to XYZ Bank Page and logged in as bank manager ForTC04
    Then the user clicks the Customers button ForTC04
    When the user clicks on the postcode column to sort
    Then the user should see customers sorted and the order type
    When the user clicks on the postcode column again to sort again
    Then the user should see customers sorted and the order type again
