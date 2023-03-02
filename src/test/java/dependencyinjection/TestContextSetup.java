package dependencyinjection;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CreateUserPojo;
import pojo.CreateUserResponsePojo;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Properties;

public class TestContextSetup {


    public static RequestSpecification req;
    public RequestSpecification requestSpecification;
    public Response res;
    PrintStream log;
    Properties prop;
    FileInputStream fr;

    public CreateUserPojo cup;
    public CreateUserResponsePojo curp;

    public TestContextSetup() throws IOException {

        prop = new Properties();
        fr = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\global.properties");
        prop.load(fr);

        if(req ==null) {
            log = new PrintStream(new FileOutputStream("Logging.txt"));
            req = new RequestSpecBuilder()
                    .setBaseUri(prop.getProperty("baseuri")).setContentType(ContentType.JSON)
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log)).build();


        }
        cup= new CreateUserPojo();
        curp = new CreateUserResponsePojo();

    }
}
