Feature: Dynamic loading and Explicit Wait

  @explicit_wait
  Scenario: User waits for dynamically loaded text to appear
    Given user is on the dynamic loading page
    When user clicks the Start button
    Then user waits for loading bar to disappear and verifies text is "Hello World!"