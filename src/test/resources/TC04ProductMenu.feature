@productstab
Feature: Product Tab Scenarios

  Scenario: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
    Given I enter username as "gurpreet.singh22@yopmail.com"
    And I enter password as "Test@123456789"
    And I login
    Then I am on homepage

  @addindustryproductfromproducttab
  Scenario Outline: Shop the Industry products from the product tab and complete the checkout
    Given I am on Homepage
    When I select the product category "<category name>" from product tab
    And I select the price filter from "<range1>" to "<range2>"
    And I add the product to the cart
    And I open the wishlist
    And I validate the product added in the cart
    And I click checkout
    And I contiue with billing and shipping information
    And I add preffered date and time "<time range>"
    And I validate product in the checkout page
    And I click on confirm order button
    Then I see order placed success message with order id
    And I entered the order id of the placed product in search field and search
    Then the ordered product corresponding to the entered order id should be visible
    And I cancel the order
    And I entered the order id of the placed product in search field and search
    Then I validate order is cancel

    Examples: 
      | category name | range1 | range2 | time range |
      | Industry      |    100 | 199.99 | 9AM-12PM   |

  @addroadtransportproduct
  Scenario Outline: Shop the Road transport products products from the product tab and complete the checkout
    Given I am on Homepage
    When I select the product category "<category name>" from product tab
    And I select the price filter from "<range1>" to "<range2>"
    And I add the product to the cart
    And I open the wishlist
    And I validate the product added in the cart
    And I click checkout
    And I contiue with billing and shipping information
    And I add preffered date and time "<time range>"
    And I validate product in the checkout page
    And I click sol logo
    And I open the wishlist
    And I remove the product from the cart and close the cart

    Examples: 
      | category name  | range1 | range2 | time range |
      | Road Transport |    100 | 199.99 | 9AM-12PM   |

  @addroadtransportproduct
  Scenario Outline: Shop the Anti-Freeze Coolant products from the product tab and complete the checkout
    Given I am on Homepage
    When I select the product category "<category name>" from product tab
    And I select the price filter from "<range1>" to "<range2>"
    And I add the product to the cart
    And I open the wishlist
    And I validate the product added in the cart
    And I click checkout
    And I contiue with billing and shipping information
    And I add preffered date and time "<time range>"
    And I validate product in the checkout page
    And I click sol logo
    And I open the wishlist
    And I remove the product from the cart and close the cart

    Examples: 
      | category name       | range1 | range2 | time range |
      | Anti-Freeze Coolant |   1000 |      0 | 9AM-12PM   |

  @addbrrakeclutchfromproducttab
  Scenario Outline: Shop the  Brake & Clutch Fluid products from the product tab and complete the checkout
    Given I am on Homepage
    When I select the product category "<category name>" from product tab
    And I select the price filter from "<range1>" to "<range2>"
    And I add the product to the cart
    And I open the wishlist
    And I validate the product added in the cart
    And I click checkout
    And I contiue with billing and shipping information
    And I add preffered date and time "<time range>"
    And I validate product in the checkout page
    And I click sol logo
    And I open the wishlist
    And I remove the product from the cart and close the cart

    Examples: 
      | category name        | range1 | range2 | time range |
      | Brake & Clutch Fluid |   1000 |      0 | 9AM-12PM   |

  @adddieselengineoilsproducttab
  Scenario Outline: Shop the Diesel Engine Oils products from the product tab and complete the checkout
    Given I am on Homepage
    When I select the product category "<category name>" from product tab
    And I select the price filter from "<range1>" to "<range2>"
    And I add the product to the cart
    And I open the wishlist
    And I validate the product added in the cart
    And I click checkout
    And I contiue with billing and shipping information
    And I add preffered date and time "<time range>"
    And I validate product in the checkout page
    And I click sol logo
    And I open the wishlist
    And I remove the product from the cart and close the cart

    Examples: 
      | category name      | range1 | range2 | time range |
      | Diesel Engine Oils |   1000 |      0 | 9AM-12PM   |

  @addGasolineengineoilsfromprodtab
  Scenario Outline: Shop the Gasoline Engine Oils products from the product tab and complete the checkout
    Given I am on Homepage
    When I select the product category "<category name>" from product tab
    And I select the price filter from "<range1>" to "<range2>"
    And I add the product to the cart
    And I open the wishlist
    And I validate the product added in the cart
    And I click checkout
    And I contiue with billing and shipping information
    And I add preffered date and time "<time range>"
    And I validate product in the checkout page
    And I click sol logo
    And I open the wishlist
    And I remove the product from the cart and close the cart

    Examples: 
      | category name        | range1 | range2 | time range |
      | Gasoline Engine Oils |   1000 |      0 | 9AM-12PM   |

  @addtransmissionfromproducttab
  Scenario Outline: Shop the Road transport products from the product tab and complete the checkout
    Given I am on Homepage
    When I select the product category "<category name>" from product tab
    And I select the price filter from "<range1>" to "<range2>"
    And I add the product to the cart
    And I open the wishlist
    And I validate the product added in the cart
    And I click checkout
    And I contiue with billing and shipping information
    And I add preffered date and time "<time range>"
    And I validate product in the checkout page
    And I click sol logo
    And I open the wishlist
    And I remove the product from the cart and close the cart
    And I logout

    Examples: 
      | category name | range1 | range2 | time range |
      | Transmission  |   1000 |      0 | 9AM-12PM   |
