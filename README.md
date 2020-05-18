# Robust-UAT

Writing robust user acceptance test cases combining cucumber, selenium and runnning it in a selenium grid.

## General overview
This tutorial shows how to run a robust user acceptance tests against our web based [hello world application](https://github.com/acapozucca/helloworld) using cucumber, selenium and selenium grid.

The test cases in this tutorial will be similar to our test cases in [Cucumber Tutorial](https://github.com/venkateshwarant/Cucumber_Tutorial) and [Selenide Tutorial](https://github.com/venkateshwarant/Selenide_Tutorial).

**NOTE**:
To run these tests, it is required to setup our product beforehand, if not done yet please follow the above link to get it configured.
You should also configure a selenium hub and a node, to do this refer [Selenium grid Tutorial](https://github.com/venkateshwarant/SeleniumGrid)

### Software

1. The Web-based Hello World case study
* Instructions to install here: https://github.com/acapozucca/helloworld/blob/master/product.helloworld/README.md
* You need to complete (at least) until the step 3 (included) of the section 
"Check local testing environment setup", and
(at least) until step 3 (included) of the section
"Run the application"

2. **Maven** (v 3.6.2, or higher)
* Instructions to install here: https://maven.apache.org/download.cgi
* Check installation with the command `mvn --version`

3. **Git** (version 2.21.1)
* Instructions to install here: https://help.ubuntu.com/lts/serverguide/git.html
* Check installation with the command `git --version`

4. **IntelliJ IDEA IDE**
* In this tutorial we will use IntelliJ IDEA as our IDE, because it has a [IntelliJ IDEA Cucumber for Java plugin](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java) to make our life easier.
* After installing the IDE, get the above plugin installed in it.

5. **Selenide** (version 5.11.1)
* Instructions to install here: https://selenide.org/quick-start.html
* maven dependency to add selenide to our project is
```
<dependency>
    <groupId>com.codeborne</groupId>
    <artifactId>selenide</artifactId>
    <version>5.11.1</version>
    <scope>test</scope>
</dependency>
```

6. **Cucumber**
* Instructions to install here: https://cucumber.io/docs/installation/java/

7. **Selenium grid**
* Instructions to install here: https://github.com/venkateshwarant/SeleniumGrid
* note that while creating a grid, you should first create a hub vm and then create a node so that you can register this node to the hub. So first vagrant up the hub-vm and then the node-vm.

## Creating the remote driver in selenide

To create a remote webdriver in selenide, we should first create the remote driver in selenium and then set this object to the selenide.

```
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
```

**Note**
* You should first follow the https://github.com/venkateshwarant/SeleniumGrid to build a selenium grid.
* Change the remote driver url from 192.168.33.13 to the corresponding hub url which you have configured. 
