package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Login_Steps {

    private WebDriver driver;

    @Before("@login")
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver.get("http://webdriveruniversity.com/Login-Portal/index.html?");
    }
    @When("I enter a username {word}")
    public void i_enter_a_username(String username) {
        WebElement loginInput = driver.findElement(By.id("text"));
        loginInput.sendKeys(username);
    }
    @When("I enter a password {word}")
    public void i_enter_a_password(String password) {
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }
    @Then("I should be presented with a successful login message")
    public void i_should_be_presented_with_a_successful_login_message() {
        String successfulLoginMessageExpected = "validation succeeded";
        String successfulLoginMessageActual = driver.switchTo().alert().getText();
        Assert.assertEquals(successfulLoginMessageActual, successfulLoginMessageExpected);
    }

    @Then("I should be presented with a unsuccessful login message")
    public void i_should_be_presented_with_a_unsuccessful_login_message() {
        String successfulLoginMessageExpected = "validation failed";
        String successfulLoginMessageActual = driver.switchTo().alert().getText();
        Assert.assertEquals(successfulLoginMessageActual, successfulLoginMessageExpected);
    }

    @Then("I should be presented with the following validation message {string}")
    public void i_should_be_presented_with_the_following_validation_message(String expectedMessage) {
        String successfulLoginMessageActual = driver.switchTo().alert().getText();
        Assert.assertEquals(successfulLoginMessageActual, expectedMessage);
    }


    @After("@login")
    public void tearDown(){
        driver.quit();
    }


}
