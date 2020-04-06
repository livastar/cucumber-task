# new feature
# Tags: optional

Feature: Search for a restaurant in New York area

  Scenario: user is redirected to the restaurant page while searching for any valid address

    Given an open browser page for blackseedbagels restaurant
    When a valid address '75 9th Ave, New York, NY 10011, USA' is entered in search field
    Then at least one matched result should be shown bold
    And clicking at first matched result
    Then user should be at restaurant with address '75 9th Ave, New York, NY 10011, USA'