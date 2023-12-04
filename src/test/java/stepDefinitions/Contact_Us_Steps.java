package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Contact_Us_Steps {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I access the webdriver university contact page")
    public void i_access_the_webdriver_university_contact_page() {
        System.out.println("Step 1");
    }
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        System.out.println("Step 2");
    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        System.out.println("Step 3");
    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        System.out.println("Step 4");
    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        System.out.println("Step 5");
    }
    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        System.out.println("Step 6");
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        System.out.println("Step 7");
    }
}
