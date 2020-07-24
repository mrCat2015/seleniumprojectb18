package test.day04_FindElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
XPATH PRACTICESDO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Locate all the WebElements on the page using XPATH locator only (total of 6)

a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered byCybertek School” text

4. Verify all WebElements are displayed.
 */

public class TC01_Forgot_Password {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        boolean homeLink = driver.findElement(By.xpath("/html/body/nav/ul/li/a")).isDisplayed();
        if(homeLink){
            System.out.println("Home link is displayed. Verification PASSED!!!");
        }else{
            System.out.println("Home link is not displayed. Verification FAILED!!!");
        }


        boolean forgotPasswordLink = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2")).isDisplayed();
        if(forgotPasswordLink){
            System.out.println("Forgot Password link is displayed. Verification PASSED!!!");
        }else{
            System.out.println("Forgot Password link is not displayed. Verification FAILED!!!");
        }


        boolean EmailTextLink = driver.findElement(By.xpath("//*[@id=\"forgot_password\"]/div/div/label")).isDisplayed();
        if(EmailTextLink){
            System.out.println("Email text link is displayed. Verification PASSED!!!");
        }else{
            System.out.println("Email text link is not displayed. Verification FAILED!!!");
        }


        boolean emailBoxLink= driver.findElement(By.xpath("//*[@id=\"forgot_password\"]/div/div/input")).isDisplayed();
        if(emailBoxLink){
            System.out.println("Email Input Box link is displayed. Verification PASSED!!!");
        }else{
            System.out.println("Email Input Box link is not displayed. Verification FAILED!!!");
        }

        boolean retrievePasswordLink = driver.findElement(By.xpath("//*[@id=\"form_submit\"]")).isDisplayed();
        if(retrievePasswordLink){
            System.out.println("Retrieve Password link is displayed. Verification PASSED!!!");
        }else{
            System.out.println("Retrieve Password Box link is not displayed. Verification FAILED!!!");
        }

        boolean poweredTextLink = driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div")).isDisplayed();
        if(poweredTextLink){
            System.out.println("Powered by Cybertek School link is displayed. Verification PASSED!!!");
        }else{
            System.out.println("Powered by Cybertek School link link is not displayed. Verification FAILED!!!");
        }


    }

}
