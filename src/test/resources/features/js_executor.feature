Feature: JavaScriptExecutor functionalities

  @js_executor
  Scenario: User scrolls down and up using JavaScriptExecutor
    Given user is on the infinite scroll page
    When user scrolls down 750 pixels using JavaScriptExecutor
    Then user scrolls up 750 pixels using JavaScriptExecutor