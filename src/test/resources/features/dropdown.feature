Feature: Dropdown options verification using DataTable

  @dropdown
  Scenario: User should see expected options in dropdown
    Given user is on the dropdown page
    Then user should see below options in the dropdown
      | Please select an option |
      | Option 1                |
      | Option 2                |