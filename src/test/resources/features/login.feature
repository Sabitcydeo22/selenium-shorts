Feature: Library app login feature
  User Story: As a user, I should be able to login to the library application

  Background:
    Given user is on the library login page

  @login @smoke
  Scenario: Login with valid credentials as a librarian
    When user enters librarian username
    And user enters librarian password
    Then user should see "dashboard" in the url

  @login_role
  Scenario: Login dynamically as different user types
    When user logs in as a "student"
    Then user should see "books" in the url

  @negative_login
  Scenario: Login with invalid credentials
    When user enters invalid email and password
    Then user should see the "Sorry, Wrong Email or Password" message

  @modules
  Scenario: Verify modules for librarian
    When user logs in as a "librarian"
    Then user should see below modules
      | Dashboard |
      | Users     |
      | Books     |