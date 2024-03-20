Feature: Testing Header Section
  As a user of the movies app website
  i should see the website logo ,
  all the navbar elements and
  i should navigate to all the corresponding pages
  successfully

  Scenario: Testing Header Section

    Given I am on login page for Header
    When I enter Valid username and password for Account for Header
    And I click on the login button for Account for Header
    Then I should see the Website logo displayed
    And I should see the Navbar elements
    When I should be navigate to Home page through elements successfully in header section
    When I should be navigate to Popular page through elements successfully in header section
    When I should be navigate to Search page through elements successfully in header section
    When I should be navigate to Account page through elements successfully in header section