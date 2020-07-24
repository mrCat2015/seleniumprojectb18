package test.day11_page_object_model;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class PositiveLoginTest {


    @Test
    public void tc32_store_manager_login_test(){
        //TC#32 : Vytrack positive login testà Sales Manager
        // 1. Go to https://qa3.vytrack.com
        // 2. Enter correct username
        // 3. Enter correct password4.
        // Verify title changedExpected: “Dashboard”
        // Note: Follow Page Object Model design pattern

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        LoginPage loginPage = new LoginPage();

        loginPage.login(ConfigurationReader.getProperty("storemanager_username"), ConfigurationReader.getProperty("storemanager_password"));

        String expectedTitle = "Dashboard";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


    }
}
