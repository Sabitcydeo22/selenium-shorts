Feature: Actions class hover functionality

  @hover
  Scenario: User hovers over image and verifies profile name
    Given user is on the hovers page
    When user hovers over the first avatar
    Then user should see the text "name: user1" displayed
