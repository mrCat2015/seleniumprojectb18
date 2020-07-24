package test.day08_alerts_iframes_windows;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class WebTablesPractices {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");



        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    // •Method takes WebDriver object and String(name).
    // •Method should verify if given name exists in orders.
    // •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    // •Create a new TestNG test to test if the method is working as expected.

    //PRACTICE #4: Method: verifyOrder
    // •Create a method named verifyOrder in SmartBearUtils class.
    @Test
    public void p4_verifyOrder_test_test(){
        SmartBearUtilities.login(driver);
        //login into smartbear
        SmartBearUtilities.verifyOrder(driver, "Bob Feather");


    }

    @Test
    public void p5_print_names_cities_test(){
        SmartBearUtilities.login(driver);
        SmartBearUtilities.printNamesAndCities(driver);


    }
}
