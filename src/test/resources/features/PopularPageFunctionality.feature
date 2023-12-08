Feature: Popular Page Test

  Scenario: Test the Popular Page UI
    Given I am on the Movies App popular page
    Then the heading should be displayed
    And the filter dropdown should be displayed
    And the movie list should be displayed

  Scenario: Test whether the movies are displayed
    Given I am on the Movies App popular page
    Then movies should be displayed
