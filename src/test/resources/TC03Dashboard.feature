@regression @dashboards
Feature: Dashboard scenarios

  Background: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
    Given I enter username as "gurpreet.singh22@yopmail.com"
    And I enter password as "Test@123456789"
    When I login
    Then I am on homepage

  Scenario: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
    Given I am on homepage and click dashboard
    Then I am on dashboard page
    And I logout

  Scenario Outline: The user should be able to review the status data of placed orders in the dashboard section of the SOL website.
    Given I am on homepage and click dashboard
    And I am on dashboard page
    And I click on order status "<status name>" tab on dashboard page
    Then I validate "<status name>" of order status should be visible for orders
    And I logout

    Examples: 
      | status name          |
      | Pending Cancellation |
