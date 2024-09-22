@regression
Feature: Login scenarios

   @logintest @regression
  Scenario Outline: Users are required to log in to the SOL website in order to access the dashboard module and review the order status on the dashboard page.
    When I enter username as "<username>"
    And I enter password as "<password>"
    #And I login
    #Then I am on homepage and logout

    Examples: 
      | username                | password      |
      | Testqa12@mailinator.com | Welcome@12345 |
