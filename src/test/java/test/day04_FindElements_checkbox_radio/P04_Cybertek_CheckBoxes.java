package test.day04_FindElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P04_Cybertek_CheckBoxes {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            // 1.Go	to	http://practice.cybertekschool.com/checkboxes
        driver.get("http://practice.cybertekschool.com/checkboxes");

            // 2.Confirm	checkbox	#1	is	NOT	selected	by	default
        WebElement checkBox1 = driver.findElement(By.xpath("(//form[@id='checkboxes']/input)[1]"));
        if(!checkBox1.isSelected()){
            System.out.println("Check box #1 is NOT selected. Verification PASSED");
        }else{
            System.out.println("Check box #1 is selected. Verification FAILED");
        }

       // 3.Confirm	checkbox	#2	is	SELECTED	by	default.
        WebElement checkBox2 = driver.findElement(By.xpath("(//form[@id='checkboxes']/input)[2]"));
        if(checkBox2.isSelected()){
            System.out.println("Check box #2 is selected. Verification PASSED");
        }else{
            System.out.println("Check box #2 is NOT selected. Verification FAILED");
        }

        // 4.Click	checkbox	#1	to	select	it.
        checkBox1.click();
        //5.Click	checkbox	#2	to	deselect	it.
        checkBox2.click();
        //6.Confirm	checkbox	#1	is	SELECTED.
        if(checkBox1.isSelected()){
            System.out.println("Check box #1 is selected. Verification PASSED");
        }else{
            System.out.println("Check box #1 is NOT selected. Verification FAILED");
        }
        //7.Confirm	checkbox	#2	is	NOT
        if(!checkBox2.isSelected()){
            System.out.println("Check box #2 is NOT selected. Verification PASSED");
        }else{
            System.out.println("Check box #2 is selected. Verification FAILED");
        }

    }
}
