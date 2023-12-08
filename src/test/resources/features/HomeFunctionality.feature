Feature: Home Page Test

  Scenario: Test the Home Page
    Given I am on the Movies App home page
    Then the heading text should be "Movies App"
    And the play button should be displayed
    And the movies should be displayed in the corresponding sections
    And the contact us section should be displayed
