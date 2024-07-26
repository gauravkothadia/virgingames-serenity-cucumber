Feature: Testing the response of games in currency specification

  @regression
  Scenario Outline: Verify that response returned is in the valid currency as specified.
    When User sends a GET request to games endpoint using currency parameter "<currency>"
    Then User must get back with a valid status code 200
    And User must get the response which contains in mentioned "<currency>"
    Examples:
      | currency |
      | GBP      |
      | EUR      |
      | SEK      |




