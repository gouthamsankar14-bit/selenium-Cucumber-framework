package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src\\test\\resources",   // 👈 correct
    glue = "stepDefenition",                    // 👈 matches your package
    monochrome = true,
    plugin = {"pretty","html:target/cucumber.html"}
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
}

