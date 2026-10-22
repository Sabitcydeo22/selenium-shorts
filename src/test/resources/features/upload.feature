Feature: File upload functionality

  @upload
  Scenario: User uploads a text file successfully
    Given user is on the upload page
    When user uploads a test file
    Then user clicks upload button and verifies text is "File Uploaded!"