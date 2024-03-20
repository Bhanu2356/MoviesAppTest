Feature: Popular Page Test
  As a user of the movies app website
  i should see the all the popular
  movies in the popular section and
  Redirect to the movie details page.

  Scenario: Test the Popular Page UI
    Given I am on login Page for Popular Movies
    When I enter valid username and password for Popular Movies
    And  I click on login button for Popular Movies
    Given I navigate to the Popular Page and click on a movie for Popular Movies
    Then I should see the Popular Page loaded successfully for Popular Movies