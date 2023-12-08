Feature: Search Page Test

  Scenario: Test the Search Functionality
    Given I am on the Movies App search page
    When I perform a search with the movie name "Harry Potter"
    Then verify the count of movies displayed
