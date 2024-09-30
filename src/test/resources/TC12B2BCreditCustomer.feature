@regression @B2BCreditCustomer
Feature: Verification of Cylinder based product from LPG, RPG select Products Tab for B2B credit customer

  Scenario: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
    When I enter username as "solb2b@techved.com"
    And I enter password as "Test@54321"
    Then I login
    Then I am on homepage

  Scenario Outline: Verification of Cylinder based product from LPG, Skip validation
    Given I am on Homepage
    When I select the product category "<category name>" from product tab
    And I select the price filter from "<range1>" to "<range2>"
    And I add product to the cart using product code "<code>"
    And I open the wishlist
    And I validate the product added in the cart
    And I click checkout
    And I contiue with billing and shipping information for sol branch
    And I skip returning empty bottles
    And I add preffered date and time "<time range>"
    And I select cash as payment
    And I validate product in the checkout page
    And I click on confirm order button
    Then I see order placed success message with order id
    And I entered the order id of the placed product in search field and search
    Then the ordered product corresponding to the entered order id should be visible

    Examples: 
      | category name | range1 | range2 | time range | code  | options         | value |
      | Cylinders     |      0 |  49.99 | 9AM-12PM   | 10050 | Return Cylinder |     1 |

  Scenario Outline: Verification of Cylinder based product from LPG, RPG select Products Tab
    Given I am on Homepage
    When I select the product category "<category name>" from product tab
    And I select the price filter from "<range1>" to "<range2>"
    And I add product to the cart using product code "<code>"
    And I open the wishlist
    And I validate the product added in the cart
    And I click checkout
    And I contiue with billing and shipping information for sol branch
    And I enter the "<value>" for return cylinders
    And I add preffered date and time "<time range>"
    And I select cash as payment
    And I click on confirm order button
    And I see order placed success message with return id
    Then I see order placed success message with order id
    And I entered the order id of the placed product in search field and search
    Then the ordered product corresponding to the entered order id should be visible
    And I select the "<options>" from dashboard menu
    And I search order id for return cyclinder
    Then the ordered product corresponding to the entered return id should be visible

    Examples: 
      | category name | range1 | range2 | time range | code  | options         | value |
      | Cylinders     |      0 |  49.99 | 9AM-12PM   | 10050 | Return Cylinder |     1 |

  Scenario Outline: Verify the Return cylinder can be submitted from Return Cylinder page
    Given I am on return and click on quantity dropdown
    And I select the "<cylinder name>" cylinder and quantity for return "<quantity>" and submit it
    And I select pickup from home with first address and submit
    Then I validate the return success message

    Examples: 
      | cylinder name                      | quantity |
      | LPG MIX 10KG/22LB FILLED METAL CYL |        1 |

  Scenario Outline: Verify the Return cylinder request can be cancelled
    Given I select the "<options>" from dashboard menu
    And I search order id for return request cyclinder
    And I am on return and click on quantity dropdown
    And I select the "<cylinder name>" cylinder and quantity for return "<quantity>" and submit it
    And I select the pickup address as return sol branch
    And I click on cancel button on searched return id
    And I validate the cancellation pop up is visible
    And I search order id for return request cyclinder
    And the ordered product corresponding to the entered return id should be visible
    Then I validate the pending cancellation status

    Examples: 
      | options         | cylinder name                      | quantity |
      | Return Cylinder | LPG MIX 10KG/22LB FILLED METAL CYL |        1 |

  Scenario Outline: User should be able to Add New user
    And I select the "<options>" from dashboard menu
    And I add new user with role "<rolename>" and "<language>"
    And I add the "<country>" and "<state>"
    Then I search the added user and it should be visible

    Examples: 
      | options      | rolename     | language | country   | state        |
      | Manage Users | Finance User | English  | St. Lucia | Anse la Raye |

  Scenario Outline: The admin user should be able to add a new child company from the company management section on the SOL website.
    Given I add new child company
    Then I select the child company from dropdown
    And I logout
    And I close the browser
