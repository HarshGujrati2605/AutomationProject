@dashboardwishlist
Feature: Wishlist from Dashboard Scenarios

  Scenario: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
    Given I enter username as "gurpreet.singh22@yopmail.com"
    And I enter password as "Test@123456789"
    Then I login

  @wishlistfromdashboard
  Scenario Outline: Users should have the ability to add an item from their wishlist to the shopping cart on the SOL website.
    Given I am on homepage and click dashboard
    And I am on dashboard page
    And I select the "<options>" from dashboard menu
    And I select the product from the wishlist from dashboard page
    And I open the wishlist
    Then I validate the product added in the cart
    And I remove the product from the cart and close the cart
    And I logout

    Examples: 
      | options  |
      | Wishlist |
