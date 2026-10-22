Feature: Iframe handling

  @iframe
  Scenario: User types text inside an iframe editor
    Given user is on the iframe page
    When user switches to the iframe and writes "Automation with Cydeo"
    Then user switches back to default content and verifies header is "An iFrame containing the TinyMCE WYSIWYG Editor"