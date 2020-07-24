package test.day12_synchronization;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordTest {
    //TC#35: Vytrack forgot password page verifications à TITLE and URL
    // 1. Go to https://qa3.vytrack.com
    // 2. Click to “Forgot your password?”link
    // 3. Verify title changed to expectedExpected: “Forgot Password”
    // 4. Verify url is as expected:Expected: “https://qa3.vytrack.com/user/reset-request”
    // Note: Follow Page Object Model design pattern


    @Test
    public void tc35(){
        Driver.getDriver().get("https://qa3.vytrack.com");
        Driver.getDriver().manage().window().maximize();

        LoginPage forgotPassword = new LoginPage();
        forgotPassword.ForgotYourPassword.click();

        String expected = "Forgot Password";
        String actual = Driver.getDriver().getTitle();

        Assert.assertEquals(expected, actual);

        String expectedURL = "https://qa3.vytrack.com/user/reset-request";
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

    }

    @Test
    public void tc36(){
        //TC#36: Vytrack forgot password pageverificationàERROR MESSAGE
        // 1.Go to https://qa3.vytrack.com/user/reset-request
        // 2.Enter random username
        // 3. Click to request button
        // 4. Verify error message is displayed
        // 5. Verify error message text is as expected.
        // Expected: There is no active user with username or email address “given text”.
        // Note: Follow Page Object Model design pattern

        Driver.getDriver().get(ConfigurationReader.getProperty("forgotpassword_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage();
        String randomString = "jugggf";
        loginPage.userNameInput.sendKeys(randomString);
        loginPage.requestButton.click();

        Assert.assertTrue(loginPage.alertMessage.isDisplayed());

        String actualMessage = loginPage.alertMessage.getText();
        String expectedMessage = "There is no active user with username or email address \""+randomString+"\".";
        Assert.assertEquals(actualMessage, expectedMessage);








    }


}
