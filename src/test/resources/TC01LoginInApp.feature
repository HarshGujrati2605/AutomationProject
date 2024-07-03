Feature: Login scenarios

   @logintest @regression
  Scenario Outline: Login on the website using B2C credentails 
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then I am on homepage and logout

    Examples: 
      | username                | password      |
      | Testqa12@mailinator.com | Welcome@12345 |
