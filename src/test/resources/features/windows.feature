Feature: Multiple Windows and Tabs handling

  @windows
  Scenario: User switches to new window and verifies title
    Given user is on the multiple windows page
    When user clicks the Click Here link to open a new window
    Then user should switch to the new window and verify title is "New Window"