@Sauce
Feature: Automation test task for Cognyte

  Scenario: Test scenario
    Given User is logged with standard_user
    When User add the first two products to shopping cart
    Then Two products are added
    When User remove the products
    Then The shopping cart is empty
    When User add the first two products to shopping cart
    Then Two products are added
    When User go to the shopping cart
    Then The products are displayed properly
    Then User go to checkout page
    And Validate field errors
    Then Clear all fields
    And Fill the form and checkout
    Then Verify the preview information
    Then Verify the successful message
    And logout
