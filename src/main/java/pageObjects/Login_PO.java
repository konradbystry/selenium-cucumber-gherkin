package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO{

    @FindBy(id = "text")
    private WebElement username_TextField;
    @FindBy(id = "password")
    private WebElement password_TextField;
    @FindBy(id = "login-button")
    private WebElement login_Button;

    public Login_PO(){
        super();
    }

    public void navigateTo_WebDriverUniversity_Login_Page(){
        String loginPageUrl = "http://webdriveruniversity.com/Login-Portal/index.html?";
        navigateTo_URL(loginPageUrl);
    }

    public void setUsername(String username){
        sendKeys(username_TextField, username);
    }

    public void setPassword(String password){
        sendKeys(password_TextField, password);
    }

    public void clickOn_Login_Button(){
        waitForWebElementAndClick(login_Button);
    }
}
