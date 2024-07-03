@addroadtransport @regression
Feature: Shop the Road transport products from the homepage and complete the checkout

  Scenario Outline: Login on the website using B2C credentails
    When I enter username as "<username>"
    And I enter password as "<password>"
    Then I login
    Then I am on homepage

    Examples: 
      | username                | password      |
      | Testqa12@mailinator.com | Welcome@12345 |

  Scenario Outline: Shop the Road transport products from the homepage and complete the checkout
    Given I am on Homepage
    When I select the product category "<category name>"
    And I select the price filter from "<range1>" to "<range2>"
    And I add the product to the cart
    And I open the cart
    Then I validate the product added in the cart
    And I remove the product from the cart and close the cart
    And I logout

    Examples: 
      | category name  | range1 | range2 |
      | Road Transport |    100 | 199.99 |
