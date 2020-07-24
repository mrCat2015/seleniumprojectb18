package test.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC_Window_Handle_Practice {
    //1.Create a new class called: WindowHandlePractice
    // 2.Create	new	test and make set	ups
    // 3.Go	to : http://practice.cybertekschool.com/windows
    // 4.Assert: Title	is	“Practice”
    // 5.Click	to:	“Click	Here” text
    // 6.Switch	to	new	Window.
    // 7.Assert: Title	is	“New Window”

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void window_handle_test(){

        Assert.assertTrue(driver.getTitle().contains("Practice"));
        WebElement clickHere = driver.findElement(By.xpath("//a[@target='_blank']"));
        clickHere.click();


        driver.switchTo().window(driver.getWindowHandle());

        Assert.assertTrue(driver.getTitle().contains("New Window"));

    }
}
