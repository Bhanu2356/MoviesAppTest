Feature: Account Page Testing
  As a user of the movies app website
  when i click on Account page ,
  i should see all the UI elements
  present and visible and
  I want to be able to log out to my account
  So that I should redirect to movies app login page


  Scenario: Successful Login for Account
    Given I am on login page for Account
    When I enter Valid username and password for Account
    And I click on the login button for Account
    Given I navigate to the Account Page for Account
    Then All UI elements should be present and visible for Account
    When User clicks on the Logout button for Account
    Then I should be redirect to login page