package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NegativeLoginTests {
    LoginPage loginPage;


    @Ignore
    @Test
    public void negative_login_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        WebElement userNameInput = Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement passwordInput = Driver.getDriver().findElement(By.id("prependedInput2"));
        WebElement loginButton = Driver.getDriver().findElement(By.id("_submit"));

        String username = ConfigurationReader.getProperty("storemanager_username");
        userNameInput.sendKeys(username);

       // String password = ConfigurationReader.getProperty("storemanager_password");
        passwordInput.sendKeys("kjgufgchg");

        loginButton.click();

        WebElement ErrorMessege = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));
        Assert.assertTrue(ErrorMessege.isDisplayed(), "Assert message is NOT displayed");

    }

    @Test
    public void negative_login_test_with_page_object(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("storemanager_username");
        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys("hgygjboi");
        loginPage.loginButton.click();


        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";

        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void tc31_wrong_username_test(){
        //TC#31: Vytrack negative login test à Wrong Username Test
        // 1. Go to https://qa3.vytrack.com
        // 2. Enter incorrectusername
        // 3. Enter correctpassword
        // 4. Verify error message text is as
        // expectedExpected: “Invalid user name or password.”
        // Note: Follow Page Object Model design pattern

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();
        loginPage.login("jhuigio", ConfigurationReader.getProperty("storemanager_password"));

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";

        Assert.assertEquals(actualText, expectedText);



    }






}
