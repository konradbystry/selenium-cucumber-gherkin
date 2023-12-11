package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.Base_PO;
import pageObjects.Contac_Us_PO;

import java.time.Duration;



public class Contact_Us_Steps extends Base_PO {

    private WebDriver driver = getDriver();

    private Contac_Us_PO contac_us_po;
    public Contact_Us_Steps (Contac_Us_PO contac_us_po){
        this.contac_us_po = contac_us_po;
    }


    @Given("I access the webdriver university contact page")
    public void i_access_the_webdriver_university_contact_page() {
        contac_us_po.navigateTo_WebDriverUniversity_Contact_Us_Page();
    }
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        contac_us_po.setUnique_FirstName();
    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
       contac_us_po.setUnique_LastName();
    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        contac_us_po.setUnique_Email();
    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        contac_us_po.setUnique_Comment();
    }
    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        contac_us_po.clickOn_SubmitButton();
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        contac_us_po.validateSuccessful_SubmissionMessage();
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        contac_us_po.setSpecific_FirstName(firstName);
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        contac_us_po.setSpecific_LastName(lastName);
    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        contac_us_po.setSpecific_Email(email);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        contac_us_po.setSpecific_Comment(comment);
    }
}
