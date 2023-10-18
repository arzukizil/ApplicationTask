@test
Feature:Employee List Page Functionality

  Background: User should access eaapp web page

    Given user is on the eaap web page
    Then user should see the title

  Scenario: User logins with valid credentials
    Given user clicks on the login button
    And user lands on the login page
    When user enters valid credentials into the field
    And user lands on dashboard
    Then user clicks on employee list on the dashboard
    When user clicks create new button on the employee list
    And user lands on Employee page
    Then user fills the fields in the form
    And user clicks create button
    Then user should see the new employee on the employee list page
    And user is on the employee list page
    Then user clicks on the Delete link of the new employee on the employee list
    And user verifies that the new employee is not on the employee list












