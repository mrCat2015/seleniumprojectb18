package test.day06_testng_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class TestNGSeleniumPractice  {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");
    }
    @AfterMethod
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.close();
    }
    @Test(priority = 2)
    public void google_title_test(){
       // driver = WebDriverFactory.getDriver("chrome");
       // driver.get("https://www.google.com");

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //if you are using assertEquals,
        //you need to pass arguments in the same type
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    @Test(priority = 1)
    public void google_search_title_verification(){
        //1- open browser
        //2- go to https://google.com
        //3- search "apple"
        //4- verify title contains "apple"
        //5- close browser
        //WebDriver driver = WebDriverFactory.getDriver("chrome");
        //driver.get("https://www.google.com");

        WebElement appleSearchBox = driver.findElement(By.name("q"));
        appleSearchBox.sendKeys("apple"+ Keys.ENTER);

        String expectedTitle = "apple";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);









    }
}
