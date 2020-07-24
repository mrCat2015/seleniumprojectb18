package pages;
/*
We will store all Login page related web elements and methods into this class
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="prependedInput")
    public WebElement userNameInput;

    @FindBy(id="prependedInput2")
    public WebElement passwordInput;

    @FindBy(id="_submit")
    public WebElement loginButton;

    @FindBy(xpath="//div[@class='alert alert-error']")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement ForgotYourPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement requestButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement alertMessage;

    public void login(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
