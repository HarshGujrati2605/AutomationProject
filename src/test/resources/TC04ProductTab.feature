@regression @productstab
Feature: Product Tab Scenarios

  Scenario: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
    Given I enter username as "gurpreet.singh22@yopmail.com"
    And I enter password as "Test@123456789"
    And I login
    Then I am on homepage
    
  @addindustryproduct
  Scenario Outline: Shop the Industry products from the homepage and complete the checkout
    Given I am on Homepage
    When I select the product category "<category name>" from product tab
    And I select the price filter from "<range1>" to "<range2>"
    And I add the product to the cart
    And I open the cart
    And I validate the product added in the cart
    And I click checkout
    
   
    Examples: 
      | category name | range1 | range2 |
      | Industry      |    100 | 199.99 |

  