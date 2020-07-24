package test.day08_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsTabsPractice {
    WebDriver driver;

    @BeforeClass
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void p5_window_handle_practice(){
        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("currentWindowHandle = "+currentWindowHandle);

        WebElement clickHereLink = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereLink.click();

        //driver.getWindowHandles() --> returns us A SET of Strings

        Set<String> windowHandles = driver.getWindowHandles();

        for(String each: windowHandles){
            driver.switchTo().window(each);
            if(driver.getTitle().equals("New Window")){
               // Assert.assertTrue();
            }
        }



    }
}
