@regression @CSCImpersonate
Feature: User login in CSC account and open the B2C account and add LPG  based
  Cylinders product on cart page from Product tab

  Scenario: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
    When I enter username as "cscadminstluciadev@yopmail.com"
    And I enter password as "Test@7654321"
    Then I login
    Then I am on homepage

  Scenario Outline: User login in CSC account and open the B2C account and add LPG  based
    Cylinders product on cart page from Product tab

    Given I click on cubic menu icon
    And I select users and organisation from menu
    And I select the "<user>" and "<useremail>" from user and organisation page and clicked on imperosnate user
    When I select the product category "<category name>" from product tab
    And I select the price filter from "<range1>" to "<range2>"
    And I add product to the cart using product code "<code>"
    And I open the wishlist
    And I validate the product added in the cart
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

    Examples: 
      | user             | category name | range1 | range2 | time range | code  | options         | value | useremail          |
      | techvedftechvedl | Cylinders     |      0 |  49.99 | 9AM-12PM   | 10050 | Return Cylinder |     1 | solb2b@techved.com |

  Scenario Outline: Verify the Return cylinder can be submitted from Return Cylinder page
    Given I am on return and click on quantity dropdown
    And I select the "<cylinder name>" cylinder and quantity for return "<quantity>" and submit it
    And I select pickup from home with first address and submit
    Then I validate the return success message
    And I close the browser

    Examples: 
      | cylinder name                      | quantity |
      | LPG MIX 10KG/22LB FILLED METAL CYL |        1 |
