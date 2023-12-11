package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Contac_Us_PO extends Base_PO{

    @FindBy(css = "input[name=\"first_name\"]")
    private WebElement firstName_TextField;

    @FindBy(css = "input[name=\"last_name\"]")
    private WebElement lastName_TextField;

    @FindBy(css = "input[name=\"email\"]")
    private WebElement email_TextField;

    @FindBy(css = "textarea[name=\"message\"]")
    private WebElement comment_TextField;

    @FindBy(css = "input[value=\"SUBMIT\"]")
    private  WebElement submitButton;

    @FindBy(css = "#contact_reply > h1")
    private  WebElement submissionMessage;

    public Contac_Us_PO(){
        super();
    }

    public void navigateTo_WebDriverUniversity_Contact_Us_Page(){
        navigateTo_URL("http://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    public void setUnique_FirstName(){
        sendKeys(firstName_TextField, "AutoFN" + getRandomNumber(5));
    }

    public void setUnique_LastName(){
        sendKeys(lastName_TextField, "AutoLN" + getRandomNumber(5));
    }

    public void setUnique_Email(){
        String email = "test" + getRandomNumber(5) + "@example.com";
        sendKeys(email_TextField, email);
    }

    public void setUnique_Comment(){
        sendKeys(comment_TextField, "AutoC" + getRandomNumber(5));
    }

    public void setSpecific_FirstName(String firstName){
        sendKeys(firstName_TextField, firstName);
    }

    public void setSpecific_LastName(String lastName){
        sendKeys(lastName_TextField, lastName);
    }

    public void setSpecific_Email(String email){
        sendKeys(email_TextField, email);
    }

    public void setSpecific_Comment(String comment){
        sendKeys(comment_TextField, comment);
    }

    public void clickOn_SubmitButton(){
        waitForWebElementAndClick(submitButton);
    }

    public void validateSuccessful_SubmissionMessage(){
        String submissionMessageTextExpected = "Thank You for your Message!";
        waitForWebElementToBeVisible(submissionMessage);
        String submissionMessageTextActual = submissionMessage.getText();
        Assert.assertEquals(submissionMessageTextActual, submissionMessageTextExpected);
    }
}
