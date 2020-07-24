package test.day03_cssSelector_xpath;
/*
TC #4: Zero Bank URLverification
1.Open Chrome browser
2.Go to http://zero.webappsecurity.com/login.html
3.Get attribute value of href from the “forgot your password”link
4.Verify attribute value containsExpected: “/forgot-password.html”
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_ZeoBankURLVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot"));

        String actualHrefValue = forgotPasswordLink.getAttribute("href");
        String excpectHrefValue = "/forgot-password.html";


        if(actualHrefValue.contains(excpectHrefValue)){
            System.out.println("Href value Verification PASSED!");
        }else{
            System.out.println("Href value Verification FAILED");
        }
        System.out.println(forgotPasswordLink);



    }
}
