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

public class TC9_SmartBear_delete_order {

    //TC #9: SmartBear delete order
    // 1.Open browser and login to SmartBear
    // 2.Delete “Mark Smith” from the list
    // 3.Assert it is deleted from the list

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        SmartBearUtilities.login(driver);

    }

    @Test
    public void Delete_Order_Test(){

        WebElement inputMark = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl03_OrderSelector"));
        inputMark.click();

        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();

        List<WebElement> list = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[2]"));

        for(WebElement each: list){
            if(each.getText().contains("Mark Smith")){
                Assert.assertTrue(!each.getText().contains("Mark Smith"));
            }
        }


    }
}
