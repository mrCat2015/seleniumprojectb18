package test.day03_cssSelector_xpath;
/*
TC #3: PracticeCybertek/ForgotPassword URL verification
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/forgot_password
3.Enter any email into input box
4.Click on Retrieve password
5.Verify URL contains: Expected: “email_sent”
6.Verify textbox displayed the content as expected.Expected: “Your e-mail’s been sent!”
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_CybertekURLVerification {
    public static void main(String[] args) {

        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");
       WebElement emailInput = driver.findElement(By.name("email"));
       emailInput.sendKeys("anyemail@gmail.com");
       WebElement retrievePassword = driver.findElement(By.id("form_submit"));
       retrievePassword.click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "email_sent";

        if(actualURL.contains(expectedURL)){
            System.out.println("URL verification PASSED!");
        }else{
            System.out.println("URL verification FAILED!");
        }

        //String actualTextBox = driver.findElement(By.name("confirmation_message")).getText();
        WebElement actualTextBox = driver.findElement(By.name("confirmation_message"));
        String actualMessage = actualTextBox.getText();
        String expectedMessage= "Your e-mail's been sent!";
        System.out.println("actual message "+actualMessage);

        if(actualMessage.equals(expectedMessage)){
            System.out.println("Confirmation message verification PASSED!");
        }else{
            System.out.println("Confirmation message verification FAILED!");
        }

        if(actualTextBox.isDisplayed()){
            System.out.println("Message is displayed, verification PASSED");
        }else{
            System.out.println("Message is NOT displayed, verification FAILED");
        }


    }
}
