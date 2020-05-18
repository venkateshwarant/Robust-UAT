package steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class LandingPageSteps {

    private static WebDriver driver;
    private static String serverBaseURL= "http://192.168.33.14:8080";
    private static String webpageURI= "/helloworld";

    @Given("browser is opened")
    public void browserIsOpened() throws MalformedURLException {
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--window-size=1200x600");
        chromeOptions.setBinary("/usr/bin/google-chrome");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.LINUX);
        capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new RemoteWebDriver(new URL("http://192.168.33.13:4444/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
        open(serverBaseURL+webpageURI);
    }

    @Then("test the content of the landing page")
    public void testTheContentOfTheLandingPage() throws InterruptedException {
        $("#content").shouldHave(text("You have reached some content here. Congratulations!"));
    }

    @Then("we close the landing page")
    public void weCloseTheBrowser() {
        driver.quit();
    }
}
