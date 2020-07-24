package test.VYtrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Vehicles_Odometer {

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement userName = Driver.getDriver().findElement(By.id("prependedInput"));
        String username = ConfigurationReader.getProperty("username");
        userName.sendKeys(username);

        WebElement passWord = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        String password = ConfigurationReader.getProperty("password");
        passWord.sendKeys(password);

        WebElement loginButton = Driver.getDriver().findElement(By.id("_submit"));
        loginButton.click();
    }
    
    //@AfterMethod
    public void tear(){
        Driver.getDriver().close();
    }

    @Test
    public void Vehicles_odometers_test() throws Exception{
        WebElement flit = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(flit).perform();
        Thread.sleep(5000);

        WebElement odometer = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[2]"));
        odometer.click();
        Thread.sleep(5000);



    }
    @Test
    public void create_vehicle_odometer(){
        WebElement createButton = Driver.getDriver().findElement(By.xpath("//a[@title='Create Vehicle Odometer']"));
        createButton.click();
    }



}
