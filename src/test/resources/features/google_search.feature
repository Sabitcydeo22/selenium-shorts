Feature: Google search functionality
  User Story: As a user, when I am on the Google search page
  I should be able to search whatever I want and see relevant results

  @data_driven
  Scenario Outline: User searches multiple terms on Google
    Given user is on Google search page
    When user types "<searchValue>" in the Google search box and clicks enter
    Then user sees "<expectedValue>" in the Google title

    Examples:
      | searchValue   | expectedValue |
      | apple         | apple         |
      | java          | java          |
      | automation    | automation    |

