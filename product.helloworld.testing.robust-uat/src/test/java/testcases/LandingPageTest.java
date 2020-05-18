package testcases;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/feature/LandingPage.feature"},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/landing-page.json",
        "html:target/landing-page"},
        glue = {"steps"})
public class LandingPageTest {
}
