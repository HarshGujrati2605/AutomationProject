@Redentialregistration
Feature: Residential registration scenarios

  Scenario Outline: User should abel to registered via Residential flow
    Given I click on register link
    And I select the "<user type>"
    And I select "<language>" and "<title>"
    And I fill the user details with country
    And I click signup button
    Then I validate the regsitration is successful
    And I close the browser
     
    Examples: 
      | user type   | language | title |
      | Residential | English  | Mr    |
