package dependencyinjection;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestContextSetup {

    JsonPath js;
    public RequestSpecification req;
    public RequestSpecification requestSpecification;
    public Response res;

    public TestContextSetup()  {

        req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/").setContentType(ContentType.JSON).build();

    }
}
