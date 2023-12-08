Feature: Movie Details Page

  Scenario: Test Movie Details in Home Page
    Given user is on the Home Page
    When user clicks on a movie
    Then verify the details on the Movie Details Page

  Scenario: Test Movie Details in Popular Page
    Given user is on the Popular Page
    When user clicks on a movie
    Then verify the details on the Movie Details Page