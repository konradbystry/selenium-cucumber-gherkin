package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

public class Login_Steps extends Base_PO {

    private WebDriver driver = getDriver();

    private Login_PO login_po;

    public Login_Steps(Login_PO login_po){
        this.login_po = login_po;
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        login_po.navigateTo_WebDriverUniversity_Login_Page();
    }
    @When("I enter a username {word}")
    public void i_enter_a_username(String username) {
        login_po.setUsername(username);
    }
    @When("I enter a password {word}")
    public void i_enter_a_password(String password) {
        login_po.setPassword(password);
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        login_po.clickOn_Login_Button();
    }
    @Then("I should be presented with a successful login message")
    public void i_should_be_presented_with_a_successful_login_message() {
        login_po.validate_SuccessfulLogin_Message();
    }

    @Then("I should be presented with a unsuccessful login message")
    public void i_should_be_presented_with_a_unsuccessful_login_message() {
        login_po.validate_UnsuccessfulLogin_Message();
    }

    @Then("I should be presented with the following validation message {string}")
    public void i_should_be_presented_with_the_following_validation_message(String expectedMessage) {
        login_po.validate_Login_Message(expectedMessage);
    }
}
