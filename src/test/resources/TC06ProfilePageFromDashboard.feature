@regression @pprofilepage
Feature: Profile page scenarios

  Scenario: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
    Given I enter username as "gurpreet.singh22@yopmail.com"
    And I enter password as "Test@123456789"
    Then I login

  @updateshippingaddress
  Scenario Outline: The user should be able to update their shipping information by clicking on the Edit icon in their profile settings on the SOL website.
    Given I am on homepage and click dashboard
    And I am on dashboard page
    And I select the "<options>" from dashboard menu
    And I update the saved address of the person with state "<statename>"
    Then I validate the saved address should be visible after update

    Examples: 
      | options | statename |
      | Profile | Surrey    |
      
  @addnewshippingaddress
  Scenario Outline: The user should be able to add a new shipping address in the shipping address section of the SOL website.
    Given I am on homepage and click dashboard
    And I am on dashboard page
    And I select the "<options>" from dashboard menu
    And I add the new address of the person with state "<statename>"
    Then I validate the new added address

    Examples: 
      | options | statename |
      | Profile | Surrey    |
      

      
  