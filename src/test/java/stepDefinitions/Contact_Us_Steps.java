package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.Base_PO;
import java.time.Duration;



public class Contact_Us_Steps extends Base_PO {

    private WebDriver driver = getDriver();


    @Given("I access the webdriver university contact page")
    public void i_access_the_webdriver_university_contact_page() {
        String contactPageUrl = "http://webdriveruniversity.com/Contact-Us/contactus.html";
        navigateTo_URL(contactPageUrl);
    }
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        WebElement firstNameInput = driver.findElement(By.cssSelector("input[name=\"first_name\"]"));
        sendKeys(firstNameInput, "AutoFN" + getRandomNumber(5));
    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        WebElement lastNameInput = driver.findElement(By.cssSelector("input[name=\"last_name\"]"));
        sendKeys(lastNameInput, "AutoLN" + getRandomNumber(5));
    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        String email = "test" + getRandomNumber(5) + "@example.com";
        WebElement emailInput = driver.findElement(By.cssSelector("input[name=\"email\"]"));
        sendKeys(emailInput, email);
    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        WebElement commentTextarea = driver.findElement(By.cssSelector("textarea[name=\"message\"]"));
        sendKeys(commentTextarea, "AutoC" + getRandomNumber(5));
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
        sendKeys(firstNameInput, firstName);
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        WebElement lastNameInput = driver.findElement(By.cssSelector("input[name=\"last_name\"]"));
        sendKeys(lastNameInput, lastName);
    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("input[name=\"email\"]"));
        sendKeys(emailInput, email);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        WebElement commentTextarea = driver.findElement(By.cssSelector("textarea[name=\"message\"]"));
        sendKeys(commentTextarea, comment);
    }
}
