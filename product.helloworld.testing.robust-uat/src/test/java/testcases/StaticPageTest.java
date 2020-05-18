package testcases;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/feature/StaticPage.feature"},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/static-page.json",
        "html:target/static-page"},
        glue = {"steps"})
public class StaticPageTest {
}
