Feature: JavaScript Alerts handling

  @alert
  Scenario: User handles JS Information Alert successfully
    Given user is on the javascript alerts page
    When user clicks the JS Alert button
    Then user should see the alert message and accept it

  @confirm_alert
  Scenario: User cancels JS Confirm Alert successfully
    Given user is on the javascript alerts page
    When user clicks the JS Confirm button
    Then user cancels the alert and sees confirmation message

  @prompt_alert
  Scenario: User enters text into JS Prompt Alert successfully
    Given user is on the javascript alerts page
    When user clicks the JS Prompt button
    Then user sends text "Cydeo QA" to the alert and accepts it