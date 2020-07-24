package test.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC10_SmartBear_Edit_order {

    //TC #10: SmartBear edit order
    // 1.Open browser and login to SmartBear
    // 2.Click to edit button from the right for “Steve Johns”
    // 3.Change name to “Michael Jordan”
    // 4.Click Update
    // 5.Assert “Michael Jordan” is in the list

    WebDriver driver;

    @BeforeMethod

    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void SmartBear_Edit_Order_test(){
        SmartBearUtilities.login(driver);

        WebElement editSteveJohns = driver.findElement(By.xpath("(//input[@type='image'])[3]"));
        editSteveJohns.click();

        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.clear();
        customerName.sendKeys("Michael Jordan");

        WebElement updateButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_UpdateButton']"));
        updateButton.click();

        List<WebElement> names = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[2]"));

        for(WebElement eachName : names){
            System.out.println(eachName.getText());
        }

        for(WebElement each: names){
            if(each.getText().equals("Michael Jordan")){
                Assert.assertEquals(each.getText(), "Michael Jordan");
            }
        }




    }
}
