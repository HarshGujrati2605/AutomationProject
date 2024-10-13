@regression @Manageusers
Feature: Manage users scenarios

  Scenario: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
    Given I enter username as "solb2b@techved.com"
    And I enter password as "Test@54321"
    Then I login

  @updateshippingaddress
  Scenario Outline: The admin user should be able to add a new user from the profile section on the SOL website.
    Given I am on homepage and click dashboard
    And I am on dashboard page
    And I select the "<options>" from dashboard menu
    And I add new user with role "<rolename>" and "<language>"
    Then I search the added user and it should be visible

    Examples: 
      | options      | rolename     |language|
      | Manage Users | Finance User |English|

      
  @addnewuserinchildcompany
  Scenario Outline: The admin user should be able to add a new child company from the company management section on the SOL website.
    Given I add new child company
    Then I select the child company from dropdown
    And I logout
    And I close the browser

    Examples: 
      | options      | rolename     |language|
      | Manage Users | Finance User |English|