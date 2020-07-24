package test.day08_alerts_iframes_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class AlertsPractices {
    //TC #1: Information alert practice
    // 1.Open browser
    // 2.Go to website: http://practice.cybertekschool.com/javascript_alerts
    // 3.Click to “Click for JS Alert”button
    // 4.Click to OK button from the alert
    // 5.Verify “You successfuly clicked an alert”text is displayed
    WebDriver driver;

    @BeforeClass
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void p1_information_alert_test1(){
        WebElement infoAlertButton = driver.findElement(By.xpath("//button[@class='btn btn-primary'][1]"));
        infoAlertButton.click();

        //1. - create the Alert instance and switch to it
        Alert alert = driver.switchTo().alert();

        //2. - Use "alert" to accept the alert
        alert.accept();

        WebElement actual = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(actual.isDisplayed());


    }

    @Test
    public void p2_confirmation_alert_test(){
        WebElement conformationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        conformationAlertButton.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();
        WebElement actualText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(actualText.isDisplayed());
    }

    @Test
    public void p3_prompt(){
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));

    }
}
