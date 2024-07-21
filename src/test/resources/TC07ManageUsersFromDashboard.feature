@regression @productstab
Feature: PWishlist from Dashboard Scenarios

  Scenario: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
    Given I enter username as "gurpreet.singh22@yopmail.com"
    And I enter password as "Test@123456789"
    Then I login

  @updateshippingaddress
  Scenario Outline: The admin user should be able to add a new user from the profile section on the SOL website.
    Given I am on homepage and click dashboard
    And I am on dashboard page
    And I select the "<options>" from dashboard menu
    And I update the saved address of the person with state "<statename>"
    Then I validate the saved address should be visible after update

    Examples: 
      | options | statename |
      | Profile | Surrey    |
      
  

      
  