# new feature
# Tags: optional

Feature: Search for a restaurant in New York area

  Scenario Outline: user is redirected to the restaurant page while searching for any valid address

    Given an open browser page for blackseedbagels restaurant
    When a valid address '<ADDRESS>' is entered in search field
    Then at least one matched result should be shown bold

    Examples:
      | ADDRESS                             |
      | 75 9th Ave, New York, NY 10011, USA |
      | 176 First Avenue, New York, NY 10009, USA                        |
      | 225 Liberty St, New York, NY 10080, USA                          |
      | 170 Elizabeth St, New York, NY 10012, USA                        |
      | 1188 Broadway, New York, NY 10001, USA                           |
      | 30 Rockefeller Plaza, Rockefeller Plaza, New York, NY 10111, USA |
