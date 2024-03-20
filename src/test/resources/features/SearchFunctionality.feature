Feature: Search Functionality Test
  As a user of the movies app website
  I search a couple of movies
  it should contain at least 1 movie
  and I should redirect to the
  searched movie details page

  Scenario: Test the Search functionality by searching with movie names
    Given I am on login page for Search
    When I enter Valid username and password for Search
    And  I click on the login button for Search
    When I click on search button for Search
    And The search results should contain at least 1 movie
    Then I should  redirect to the searched movie details page for Search

    And I Search for another movie as Squid Game for Search
    And The search results should contain at least 1 movie for secound movie search
    Then I should  redirect to the searched movie details page for secound movie search Search