package test.office_hours;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class June24 {
    WebDriver driver;

    @BeforeMethod //to run before every test method

    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

    }
    @Test(description = "Test for Google")
    public void test(){
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");
    }
    @Test(description = "Test of Amazon")
    public  void amazonTest(){
        driver.get("https://www.amazon.com/");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
    }




    @AfterMethod//to run after every test method
    public void tearDown(){


    }
}
