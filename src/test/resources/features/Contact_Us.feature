@contact-us @regression

Feature: WebDriver University - Contact Us Page

  Scenario: Validate Successful Submision - Unique Data
    Given I access the webdriver university contact page
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission message

  Scenario: Validate Successful Submision - Specific Data
    Given I access the webdriver university contact page
    When I enter a specific first name Joe
    And I enter a specific last name Blogs
    And I enter a specific email address test@example.com
    And I enter a specific comment "Test comment"
    And I click on the submit button
    Then I should be presented with a successful contact us submission message