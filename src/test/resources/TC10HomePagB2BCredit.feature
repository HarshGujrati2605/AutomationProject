@regression @B2BCProducts
Feature: Shop the  products from the homepage and complete the checkout for B2B users

  Scenario: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
    When I enter username as "solb2b@techved.com"
    And I enter password as "Test@54321"
    Then I login
    Then I am on homepage

  Scenario Outline: Verification of Gasoline product from home page
  When I select the product category "<category name>"
  And I add the product to the cart
  And I open the wishlist
  Then I validate the product added in the cart
  And I click checkout
  And I contiue with billing and shipping information for sol branch
  And I add preffered date and time "<time range>"
  And I validate product in the checkout page
  And I click on confirm order button
  Then I see order placed success message with order id
  And I entered the order id of the placed product in search field and search
  Then the ordered product corresponding to the entered order id should be visible
  And I click home
  
  Examples:
  | category name | time range |
  | Gasoline      | 9AM-12PM   |
  
  Scenario Outline: Verification of Cylinder product from home page
  When I select the product category "<category name>"
  And I add the product to the cart
  And I open the wishlist
  Then I validate the product added in the cart
  And I click checkout
  And I contiue with billing and shipping information for sol branch
  And I enter the "<value>" for return cylinders
  And I add preffered date and time "<time range>"
  And I validate product in the checkout page
  And I click on confirm order button
  And I see order placed success message with return id
  Then I see order placed success message with order id
  And I entered the order id of the placed product in search field and search
  Then the ordered product corresponding to the entered order id should be visible
  And I select the "<options>" from dashboard menu
  And I search order id for return cyclinder
  Then the ordered product corresponding to the entered return id should be visible
  And I click home
  
  Examples:
  | category name | time range | value | options         |
  | Cylinders     | 9AM-12PM   |     1 | Return Cylinder |
  
  
  Scenario Outline: Verification of transmission oils product from home page
    When I select the product category "<category name>"
    And I add the product to the cart
    And I open the wishlist
    Then I validate the product added in the cart
    And I click checkout
    And I contiue with billing and shipping information for sol branch
    And I add preffered date and time "<time range>"
    And I validate product in the checkout page
    And I click on confirm order button
    Then I see order placed success message with order id
    And I entered the order id of the placed product in search field and search
    Then the ordered product corresponding to the entered order id should be visible
    And I click home
    Examples: 
      | category name        | time range |
      | Compressor Oil       | 9AM-12PM   |
      
  
  Scenario Outline: Verification of engine-oils  product from home page
  When I select the product category "<category name>"
  And I add the product to the cart
  And I open the wishlist
  Then I validate the product added in the cart
  And I click checkout
  And I contiue with billing and shipping information for sol branch
  And I add preffered date and time "<time range>"
  And I validate product in the checkout page
  And I click on confirm order button
  Then I see order placed success message with order id
  And I entered the order id of the placed product in search field and search
  Then the ordered product corresponding to the entered order id should be visible
  And I click home
  
  Examples:
  | category name | time range |
  |  Engine Oils  | 9AM-12PM   |
  
  Scenario Outline: Verification of gear-oil product from home page
  When I select the product category "<category name>"
  And I add the product to the cart
  And I open the wishlist
  Then I validate the product added in the cart
  And I click checkout
  And I contiue with billing and shipping information for sol branch
  And I add preffered date and time "<time range>"
  And I validate product in the checkout page
  And I click on confirm order button
  Then I see order placed success message with order id
  And I entered the order id of the placed product in search field and search
  Then the ordered product corresponding to the entered order id should be visible
  And I click home
  
  Examples:
  | category name | time range |
  |  Gear Oil     | 9AM-12PM   |
  
  Scenario Outline: Verification of hydraulic-oils product from home page
  When I select the product category "<category name>"
  And I add the product to the cart
  And I open the wishlist
  Then I validate the product added in the cart
  And I click checkout
  And I contiue with billing and shipping information for sol branch
  And I add preffered date and time "<time range>"
  And I validate product in the checkout page
  And I click on confirm order button
  Then I see order placed success message with order id
  And I entered the order id of the placed product in search field and search
  Then the ordered product corresponding to the entered order id should be visible
  And I click home
  
  Examples:
  | category name  | time range |
  | Hydraulic Oils | 9AM-12PM   |
  
  Scenario Outline: Verification of outboard-engine-oils product from home page
    When I select the product category "<category name>"
    And I add the product to the cart
    And I open the wishlist
    Then I validate the product added in the cart
    And I click checkout
    And I contiue with billing and shipping information for sol branch
    And I add preffered date and time "<time range>"
    And I validate product in the checkout page
    And I click on confirm order button
    Then I see order placed success message with order id
    And I entered the order id of the placed product in search field and search
    Then the ordered product corresponding to the entered order id should be visible
    And I click home

    Examples: 
      | category name        | time range |
      | Outboard Engine Oils | 9AM-12PM   |
      
      
    Scenario Outline: Verification of transmission oils product from home page
    When I select the product category "<category name>"
    And I add the product to the cart
    And I open the wishlist
    Then I validate the product added in the cart
    And I click checkout
    And I contiue with billing and shipping information for sol branch
    And I add preffered date and time "<time range>"
    And I validate product in the checkout page
    And I click on confirm order button
    Then I see order placed success message with order id
    And I entered the order id of the placed product in search field and search
    Then the ordered product corresponding to the entered order id should be visible
    And I click home
    And I logout
    And I close the browser

    Examples: 
      | category name        | time range |
      | Transmission Oils    | 9AM-12PM   |
      
