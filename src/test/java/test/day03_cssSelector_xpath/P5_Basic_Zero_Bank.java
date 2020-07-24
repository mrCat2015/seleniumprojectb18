package test.day03_cssSelector_xpath;
/*
TC #5: Basic authentication Zero Bank
1.Open Chrome browser
2.Go to http://zero.webappsecurity.com/login.html
3.Enter username: username
4.Enter password: password
5.Click sign in button
6.Verify username is displayed on the page
7.Verify the title Zero –Account Summary
8.Verify the link Account Summary’s href value contains: “account-summary”Print out results in validation formats
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_Basic_Zero_Bank {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();

       // driver.findElement(By.)



        String actualTitle = driver.getTitle();
        String expectTitle = "Account Summary";

        if(actualTitle.contains(expectTitle)){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }

    }
}
