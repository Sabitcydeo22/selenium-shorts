Feature: WebTables data verification

  @webtables
  Scenario: User verifies specific row and cell data in a table
    Given user is on the tables page
    When user locates the record for "Jason"
    Then user verifies that "Jason" has a due amount of "$100.00"