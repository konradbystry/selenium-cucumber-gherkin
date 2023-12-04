package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class Contact_Us_Steps {

    private WebDriver driver;

    @Before
    public void setup(){
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public String getRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }


    @Given("I access the webdriver university contact page")
    public void i_access_the_webdriver_university_contact_page() {
        String contactPageUrl = "http://webdriveruniversity.com/Contact-Us/contactus.html";
        driver.get(contactPageUrl);
    }
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        WebElement firstNameInput = driver.findElement(By.cssSelector("input[name=\"first_name\"]"));
        firstNameInput.sendKeys("AutoFN" + getRandomNumber(5));
    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        WebElement lastNameInput = driver.findElement(By.cssSelector("input[name=\"last_name\"]"));
        lastNameInput.sendKeys("AutoLN" + getRandomNumber(5));
    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        String email = "test" + getRandomNumber(5) + "@example.com";
        WebElement emailInput = driver.findElement(By.cssSelector("input[name=\"email\"]"));
        emailInput.sendKeys(email);
    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        WebElement commentTextarea = driver.findElement(By.cssSelector("textarea[name=\"message\"]"));
        commentTextarea.sendKeys("AutoC" + getRandomNumber(5));
    }
    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        WebElement submitButton = driver.findElement(By.cssSelector("input[value=\"SUBMIT\"]"));
        submitButton.click();
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String submissionMessageTextExpected = "Thank You for your Message!";
        WebElement submissionMessage = driver.findElement(By.cssSelector("#contact_reply > h1"));
        wait.until(ExpectedConditions.visibilityOf(submissionMessage));
        String submissionMessageTextActual = submissionMessage.getText();
        Assert.assertTrue(submissionMessageTextActual.equalsIgnoreCase(submissionMessageTextExpected));
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        WebElement firstNameInput = driver.findElement(By.cssSelector("input[name=\"first_name\"]"));
        firstNameInput.sendKeys(firstName);
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        WebElement lastNameInput = driver.findElement(By.cssSelector("input[name=\"last_name\"]"));
        lastNameInput.sendKeys(lastName);
    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("input[name=\"email\"]"));
        emailInput.sendKeys(email);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        WebElement commentTextarea = driver.findElement(By.cssSelector("textarea[name=\"message\"]"));
        commentTextarea.sendKeys(comment);
    }
}