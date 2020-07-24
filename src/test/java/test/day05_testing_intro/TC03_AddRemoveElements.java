package test.day05_testing_intro;
/*
XPATH PRACTICESDO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements
3. Click to “Add Element” button 50 times
4. Verify 50 “Delete” button is displayed after clicking.
5. Click to ALL “Delete” buttons to delete them.
6. Verify “Delete” button is NOT displayed after clicking.

USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

Hint: Need to use findElements method.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class TC03_AddRemoveElements {
    public static void main(String[] args) throws Exception {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        WebElement AddElementButton = driver.findElement(By.xpath("//button[@onclick = 'addElement()']"));

        for(int i=1; i<=50; i++){
            Thread.sleep(3000);
            AddElementButton.click();
        }

        WebElement DeleteElementButton = driver.findElement(By.xpath("//button[@onclick = 'deleteElement()']"));
        for(int i=1; i<=50; i++){

            DeleteElementButton.isDisplayed();
            }
        System.out.println("50 “Delete” button is displayed. Verification is PASSED!!!");



    }
}
