@login @regression

  Feature: WebDriver University - Login Page

    Background:
      Given I access the webdriver university login page

      @success-login
    Scenario: Validate Successful Login
      When I enter a username webdriver
      And I enter a password webdriver123
      And I click on the login button
      Then I should be presented with a successful login message

    Scenario: Validate Unsuccessful Login
      When I enter a username webdriver
      And I enter a password password123
      And I click on the login button
      Then I should be presented with a unsuccessful login message

    Scenario Outline: Validate Successful & Unsuccessful Login
      When I enter a username <username>
      And I enter a password <password>
      And I click on the login button
      Then I should be presented with the following validation message <loginValidationMessage>

      Examples:
      | username | password | loginValidationMessage |
      | webdriver | webdriver123 | "validation succeeded" |
      | webdriver | password123 | "validation failed" |