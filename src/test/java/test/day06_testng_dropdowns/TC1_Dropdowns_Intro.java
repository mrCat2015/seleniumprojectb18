package test.day06_testng_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC1_Dropdowns_Intro {
    /*
    TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/dropdown
    3.Verify “Simple dropdown” default selected value is correct
      Expected: “Please select an option”
    4.Verify“State selection” default selected value is correct
      Expected: “Select a State”
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.close();
    }


    @Test
    public void test1_default_value_verification() {
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        String actualDefaultOfSimpleDropdown = simpleDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOfSimpleDropdown = "Please select an option";

        Assert.assertEquals(actualDefaultOfSimpleDropdown, expectedDefaultOfSimpleDropdown);
        //4. Verify“State selection” default selected value is correct
        //Expected: “Select a State”

        Select stateSelection = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String actualStateSelection = stateSelection.getFirstSelectedOption().getText();
        String expectStateSelection = "Select a State";

        Assert.assertEquals(actualStateSelection, expectStateSelection);

    }

    @Test
    public void state_dropdown_verification() throws Exception{
        /*
    TC #2: Selecting state from State dropdown and verifying result
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/dropdown

    6.Verify final selected option is California.
    Use all Select options.(visible text, value, index)
     */
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        Thread.sleep(2000);

        // 3.Select Illinois by value
        stateDropdown.selectByValue("IL");
        Thread.sleep(2000);

        //4.Select Virginia by text
        stateDropdown.selectByVisibleText("Virginia");
        Thread.sleep(2000);

        //5.Select California by index
        stateDropdown.selectByIndex(5);


        String expectedOption = "California";
        String actualSelectedOption = stateDropdown.getFirstSelectedOption().getText();

        //Assert.assertEquals(expectedOption,actualSelectedOption);
        Assert.assertTrue(actualSelectedOption.contains(expectedOption));
    }


}
