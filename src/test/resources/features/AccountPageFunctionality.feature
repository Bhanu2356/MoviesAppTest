Feature: Account Page Test

  Scenario: Test the Account Page UI
    Given I am on the Movies App account page
    When I click the profile image
    Then verify the expected behavior after clicking the image
    Then the heading should be displayed
    And the username should be displayed
    And the email should be displayed
    And the logout button should be displayed

  Scenario: Test the Logout functionality
    Given I am on the Movies App account page
    When I click the logout button
    Then the login page should be displayed
