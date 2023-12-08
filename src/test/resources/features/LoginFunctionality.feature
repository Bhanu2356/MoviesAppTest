Feature: Login Page Tests

  Scenario: Verify Login Page UI
    Given User is on the login page
    Then Verify the Website logo image is displayed
    And Verify the Heading text is "Login"
    And Verify the Username label text is "USERNAME"
    And Verify the Password label text is "PASSWORD"
    And Verify the "Login" button

  Scenario: Verify Login Page Functionalities
    Given User is on the login page
    Then Test the login functionality with empty input fields
    And Test the login functionality with empty USERNAME
    And Test the login functionality with empty PASSWORD
    And Test the login functionality with Invalid Credentials
    And Test the login functionality with Valid Credentials
    When User closes the browser window
    Then Browser window should be closed
