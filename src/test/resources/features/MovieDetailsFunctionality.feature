Feature: Movie Details Page
  As a user of the movies app website
  when i click a movie in a home page
  i should see the movie details page and
  all the UI elements present in it
  Similarly when i click a movie in a popular page
  i should see the movie details page and all the UI
  elements present in it

  Scenario: View Movie Details from Home Page Movie Details
    Given I am on login Page for Movie Details
    When I enter valid username and password for Movie Details
    And  I click on login button for Movie Details
    When I click on a movie in Home Page for Movie Details
    Then I should see the movie details page for Movie Details
    And i should see all the UI elements are present and visible
    And I click on a movie in Popular Page for Movie Details