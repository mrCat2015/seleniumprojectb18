package test.Practice;

import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class TC4_VerityOrder {
    //PRACTICE #4: Method: verifyOrder
    // •Create a method named verifyOrderin SmartBearUtils class.
    // •Methodtakes WebDriver object and String(name).
    // •Methodshould verify if given name exists in orders.
    // •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    // •Create a new TestNG test to test if the method is working as expected.


    public void verifyOrder(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("");


    }



}
