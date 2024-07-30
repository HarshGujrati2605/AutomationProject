@regression @commercialregistration
Feature: Commercial registration scenarios

  Scenario Outline: User should abel to registered via Commercial flow
    Given I click on register link
    And I select the "<user type>"
    And I select "<language>" and "<title>"
    And I fill the user details with country
    And I click signup button
    Then I validate the regsitration is successful

    Examples: 
      | user type   | language | title |
      | Commercial  | English  | Mr    |
