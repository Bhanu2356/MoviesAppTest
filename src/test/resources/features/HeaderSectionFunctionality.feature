Feature: Header Section Tests

  Scenario: Test Header Section UI
    Given I am on the Movies App
    Then Website logo is displayed
    And Navbar elements are displayed

  Scenario: Test Header Section Functionalities
    Given I am on the Movies App
    When I navigate to the Home page through header section
    Then Welcome message is displayed on Home page
    When I navigate to the Popular page through header section
    Then Popular movies list is displayed
    When I navigate to the Account page through header section
    Then Account details are displayed
