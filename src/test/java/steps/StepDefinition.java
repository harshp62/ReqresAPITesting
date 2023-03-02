package steps;

import dependencyinjection.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pojo.CreateUserPojo;
import pojo.CreateUserResponsePojo;
import utilities.ReusableMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class StepDefinition extends ReusableMethods {

    TestContextSetup testContextSetup;

    public StepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;
    }

    @Given("Register user payload")
    public void register_user_payload() throws IOException {

        testContextSetup.requestSpecification = given().spec(testContextSetup.req)
                .log().all().body(getPayload("RegistrationPayload"));

    }
    @When("user sends a registration post httprequest")
    public void user_sends_a_registration_post_httprequest() {
       testContextSetup.res  = testContextSetup.requestSpecification.when().post("api/register");

    }
    @Then("then the status code is {string}")
    public void then_the_status_code_is(String string) {
        testContextSetup.res.then().assertThat().statusCode(Integer.parseInt(string));

    }
    @Then("a valid id and token is generated")
    public void a_valid_id_and_token_is_generated() {

        String newRes = testContextSetup.res.then().extract().response().asString();
        assertTrue(!parseJsonRes(newRes,"token").toString().isEmpty());
    }


    @Given("Login user payload")
    public void loginUserPayload() throws IOException {

       testContextSetup.requestSpecification = given().spec(testContextSetup.req)
                .log().all().body(getPayload("LoginPayload"));



    }

    @When("user sends a login post http request")
    public void userSendsALoginPostHttpRequest() {

        testContextSetup.res = testContextSetup.requestSpecification.when().post("api/login");

    }

    @Given("Create user payload with {string} and {string}")
    public void createUserPayloadWithAnd(String arg0, String arg1) {
        testContextSetup.cup.setName(arg0);
        testContextSetup.cup.setJob(arg1);
        testContextSetup.requestSpecification = given().spec(testContextSetup.req)
                .log().all().body(testContextSetup.cup);


    }

    @When("user sends a create post http request")
    public void userSendsACreatePostHttpRequest() {

        testContextSetup.res = testContextSetup.requestSpecification.when().post("api/users");

    }

    @And("response content-type is {string}")
    public void responseContentTypeIs(String arg0) {
        testContextSetup.res.then().assertThat().contentType(arg0);

    }

    @And("{string} and {string} is displayed in the return body")
    public void andIsDisplayedInTheReturnBody(String arg0, String arg1) {

        testContextSetup.curp = testContextSetup.res.then().extract().response().as(CreateUserResponsePojo.class);
        System.out.println(testContextSetup.curp.getName());
        System.out.println(testContextSetup.curp.getJob());
        assertTrue(testContextSetup.curp.getName().equalsIgnoreCase(arg0) && testContextSetup.curp.getJob().equalsIgnoreCase(arg1));

    }
}
