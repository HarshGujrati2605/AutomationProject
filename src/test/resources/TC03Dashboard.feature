@regression @dashboards
Feature: Shop the Industry products from the homepage and complete the checkout

  Background: Validating the login functionality
    When I enter username as "Testqa12@mailinator.com "
    And I enter password as "Welcome@12345"
    Then I login
    Then I am on homepage
