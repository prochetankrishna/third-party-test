Feature: Verify Response from Telesign

  Scenario: Successful Response
    Given Lookup Request is sent to Broker Service
    When POST method is called
    Then Server should response with successful lookup and with recommendation to block
