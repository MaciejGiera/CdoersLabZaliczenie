Feature: CodersGuru registration

  Scenario Outline: user can register private user

    Given an open browser with https://tester.codersguru.pl/
    When go to registration page
    And user enter valid data (<firstName>, <lastName>, <password>, <city>, <postalCode>, <street>, <houseNumber>)
    Then check if registration was successful

    Examples:
      | firstName | lastName | password | city | postalCode | street | houseNumber |
      |   John    |     Doe  | password |Warsaw|   09-213   | Pchla  |    21       |


