@regression @CSCImpersonate
Feature: User login in CSC account and open the B2C account and add LPG  based
  Cylinders product on cart page from Product tab

  Scenario: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
    When I enter username as "cscadminstluciadev@yopmail.com"
    And I enter password as "Test@7654321"
    Then I login
    Then I am on homepage

  Scenario Outline: Verification of Cylinder based product from LPG, RPG select Products Tab
    with the help of CSC account for B2C user

    Given I am on Homepage
    And I click on cubic menu icon
   
    Examples: 
      | category name | range1 | range2 | time range | code  | options         | value |
      | Cylinders     |      0 |  49.99 | 9AM-12PM   | 10050 | Return Cylinder |     1 |

