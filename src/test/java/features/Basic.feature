Feature: Registration
  Scenario: Test Regisration
    Given Register user payload
    When user sends a registration post httprequest
    Then then the status code is "200"
    And a valid id and token is generated

  Scenario: Test Login
    Given Login user payload
    When user sends a login post http request
    Then then the status code is "200"
    And a valid id and token is generated