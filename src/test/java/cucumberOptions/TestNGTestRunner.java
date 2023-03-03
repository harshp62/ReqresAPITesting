package cucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\features",
glue = "steps", dryRun = false,monochrome = true, tags = "@Update",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
