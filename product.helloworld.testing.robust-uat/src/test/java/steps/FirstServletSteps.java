package steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FirstServletSteps {

    private static WebDriver driver;
    private static String serverBaseURL= "http://192.168.33.14:8080";
    private static String webpageURI= "/helloworld/FirstServlet";

    @Given("empty browser is opened")
    public void emptyBrowserIsOpened() throws MalformedURLException {
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
    }

    @And("navigate to the FirstServlet URL")
    public void navigateToTheFirstServletURL() throws InterruptedException {
        open(serverBaseURL+webpageURI);
    }

    @Then("test whether Hi there content is there in the web page")
    public void testWhetherHiThereContentIsThereInTheWebPage() {
        $("#hi").shouldHave(text("Hi There!"));
    }

    @And("close the first servlet web page")
    public void closeTheBrowser() {
        driver.quit();
    }
}
