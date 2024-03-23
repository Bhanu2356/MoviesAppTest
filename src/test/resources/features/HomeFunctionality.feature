Feature: Testing Home Page
  As a user of the movies app website
  i should able to navigate to all the header sections
  and able to see heading texts of each section , play
  button , contact us section and all the movies are
  displayed in the corresponding sections

  Scenario: Test the Home Page Functionality
    Given I am on login Page for Home
    When  I enter valid username and password for Home
    And   I click on login button for Home
    Given User navigates to the Home Page
    Then  User should see the heading texts of each section
    And   User should see the play button displayed
    Then  User should see the Movies displayed in the corresponding sections
    And   User should see the Contact Us Section