package test.day02_findElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
TC #3: Back and forth navigation
1-Open a chrome browser
2-Go to: https://google.com
3-Click to Gmail from top right.
4-Verify title contains:Expected: Gmail
5-Go back to Google by using the .back();
6-Verify title equals:Expected: Google
 */

public class TC3_BackAndForthNavigation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.findElement(By.linkText("Gmail")).click();



        String actualGmailTitle = driver.getTitle();
        String expectedInTitle = "Gmail";

        if(actualGmailTitle.contains(expectedInTitle)){
            System.out.println("Gmail title verification PASSED!!!");
        }else{
            System.out.println("Gmail title verification FAILED!!!");
        }

        driver.navigate().back();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Google title verification PASSED!!!");
        }else{
            System.out.println("Google title verification FAILED!!!");
        }
    }
}
