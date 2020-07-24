package test.day08_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class iFramePractice {
    //TC #4: Iframe practice
    // 1.Create a new class called: IframePractice
    // 2.Create new test and make set ups
    // 3.Go to: http://practice.cybertekschool.com/iframe


    WebDriver driver;

    @BeforeClass
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void iFrame_practice_test(){

        //1. - locating iframe as web element, then switching to it
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        //switching to iframe using webElement
        driver.switchTo().frame(iframe);

        // 4.Assert: “Your content goes here.” Text is displayed.
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(yourContentGoesHereText.isDisplayed());

        driver.switchTo().parentFrame();
        // 5.Assert: “An iFrame containing the TinyMCEWYSIWYG Editor
        WebElement h3Text = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(h3Text.isDisplayed());

    }
}
