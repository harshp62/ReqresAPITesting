Feature: Registration
  @Register
  Scenario: Test Regisration
    Given Register user payload
    When user sends a registration post httprequest
    Then then the status code is "200"
    And a valid id and token is generated
@Login
  Scenario: Test Login
    Given Login user payload
    When user sends a login post http request
    Then then the status code is "200"
    And a valid id and token is generated

    @Create
   Scenario Outline: Test Create
     Given Create user payload with "<name>" and "<job>"
     When user sends a create post http request
     Then then the status code is "201"
     And response content-type is "application/json"
     And "<name>" and "<job>" is displayed in the return body

     Examples:
     |name    |job       |
     |Tony    |Mobster   |
     |Thomas  |Druglord  |

     @Update
     Scenario: Test Update user
       Given Update user payload
       When user sends a update patch http request
       Then then the status code is "200"
       And response server is "cloudflare"

