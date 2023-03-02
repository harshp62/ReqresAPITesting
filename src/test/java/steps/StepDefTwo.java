package steps;

import dependencyinjection.TestContextSetup;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefTwo {


    TestContextSetup testContextSetup;


    public StepDefTwo (TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }
//    @When("user sends a registration post httprequest")
//    public void user_sends_a_registration_post_httprequest() {
//        testContextSetup.res = testContextSetup.requestSpecification.when().post("api/register");
//
//    }
}
