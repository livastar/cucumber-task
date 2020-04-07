# new feature
# Tags: optional

Feature: Search feature

  Scenario Outline: user is presented with matched addresses while searching for any valid address

    Given an open browser page for blackseedbagels restaurant
    When an address '<ADDRESS>' is entered in search field
    Then at least one matched result should be shown bold

    Examples:
      | ADDRESS                             |
      | 75 9th Ave, New York, NY 10011, USA |
      | 9th Ave, New York, NY 10011         |
      | 75 9TH AVE                          |
      | 75 9th ave                          |
      | NY 10011                            |


  Scenario Outline: user is presented with no results while searching for any invalid address

    Given an open browser page for blackseedbagels restaurant
    When an address '<INVALID_ADDRESSES>' is entered in search field
    Then there is no search results shown

    Examples:
      | INVALID_ADDRESSES                  |
      | AHDSINEIfasdffasdfa 2, aos4        |
      | 0000000000000                      |
      | **./.,/,;$$$*$**_)+)(_)*@*)(*__()* |


  Scenario: user is presented with an error when the searching matched result is not selected

    Given an open browser page for blackseedbagels restaurant
    When an address 'Chisinau Moldova' is entered in search field
    And user clicks on search button
    Then user is presented with an error: 'Please be more specific'


  Scenario Outline: user is redirected to the selected restaurant menu page

    Given an open browser page for blackseedbagels restaurant
    When an address '<ADDRESS>' is entered in search field
    And from the list user selects search result with address '<ADDRESS>'
    Then restaurant card is presented the first in the list
    And user selects the card with address '<ADDRESS>'
    Then user is redirected to the selected restaurant with address '<ADDRESS>'

    Examples:
      | ADDRESS                                   |
      | 75 9th Ave, New York, NY 10011, USA       |
      | 176 First Avenue, New York, NY 10009, USA |
      | 170 Elizabeth St, New York, NY 10012, USA |
      | 1188 Broadway, New York, NY 10001, USA    |