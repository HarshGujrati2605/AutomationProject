@regression @dashboards
Feature: Dashboard scenarios

  Background: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
    Given I enter username as "gurpreet.singh22@yopmail.com"
    And I enter password as "Test@123456789"
    Then I login

  #@validatedashboardpage
  #Scenario: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
  #Given I am on homepage and click dashboard
  #Then I am on dashboard page
  #And I logout
  #
  #@orderplaced
  #Scenario Outline: Review Placed Order Status Data in Dashboard
  #Given I am on homepage and click dashboard
  #And I am on dashboard page
  #And I click on order status "<status name>" tab on dashboard page
  #Then I validate "<status name>" of order status should be visible for orders
  #And I logout
  #
  #Examples:
  #| status name |
  #| Placed      |
  #
  #@orderpendingcancellation
  #Scenario Outline: Review Pending Cancellation Status Data in Dashboard
  #Given I am on homepage and click dashboard
  #And I am on dashboard page
  #And I click on order status "<status name>" tab on dashboard page
  #Then I validate "<status name>" of order status should be visible for orders
  #And I logout
  #
  #Examples:
  #| status name          |
  #| Pending Cancellation |
  #
  #@searchorderusingid
  #Scenario Outline: User should able to search the Order using Order ID
  #Given I am on homepage and click dashboard
  #And I am on dashboard page
  #And I entered the order id "<orderid>" of the product in search field and search
  #Then the product corresponding to the entered "<orderid>" should be visible
  #
  #Examples:
  #| orderid |
  #| 4295234 |
  @searchorderdaterange
  Scenario: User should able to search the Order using date range option
    Given I am on homepage and click dashboard
    And I am on dashboard page
    Then I click on date filter and select range and validate the dates
      | range    |
      | 3 Month  |
      | 6 Month  |
      | 12 Month |
