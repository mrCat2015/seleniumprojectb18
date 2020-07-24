package test.day04_FindElements_checkbox_radio;
/*
TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements/
3. Click to "Add Element" button
4. Verify "Delete" button is displayed after clicking.
5. Click to "Delete" button.
6. Verify "Delete" button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02_AddRemiveElements {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();

        boolean deleteButtonVerify = driver.findElement(By.xpath("//*[@id=\"elements\"]/button")).isDisplayed();

        if(deleteButtonVerify){
            System.out.println("Delete button is displayed. Verification PASSED!!!");
        }else{
            System.out.println("Delete button is displayed. Verification FAILED!!!");
        }

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/button")).click();///html/body/div/div[2]/div/div/div/button
        String deleteButtonVerify2 = driver.findElement(By.xpath("/html/body/div")).getText();

        if(deleteButtonVerify2.contains("Delete")){
            System.out.println("Delete button is displayed. Verification PASSED!!!");
        }else{
            System.out.println("Delete button is displayed. Verification FAILED!!!");
        }
    }
}
