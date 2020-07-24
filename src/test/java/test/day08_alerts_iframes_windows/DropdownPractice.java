package test.day08_alerts_iframes_windows;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class DropdownPractice {

    WebDriver driver;

    @BeforeClass
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void p7_month_dropdown_default_value_test(){

    }

}
