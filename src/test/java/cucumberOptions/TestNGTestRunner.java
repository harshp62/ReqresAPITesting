package cucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\features",
glue = "steps", dryRun = false,monochrome = true,
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
