package test.day04_FindElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class PO05_SeleniumEasy_CheckBox {
    /*
    TC	#2:	SeleniumEasy	CheckboxVerification–Section	1
    1.Open	Chrome	browser
    2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    3.Verify	“Success – Check	box	is	checked”	message	is	NOTdisplayed.
    4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
    5.Verify	“Success	–Check	box	is	checked”	message	isdisplayed.
     */
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //  //form[@id='checkboxes']/input

       WebElement box1 = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));

       if(!box1.isSelected()){
           System.out.println("“Success – Check box is checked” message is NOT displayed, Verification PASSED");
       }else{
           System.out.println("“Success – Check box is checked” message is displayed, Verification FAILED");
       }

       box1.click();
        if(box1.isSelected()){
            System.out.println("“Success – Check box is checked” message is displayed, Verification PASSED");
        }else{
            System.out.println("“Success – Check box is checked” message is NOT displayed, Verification FAILED");
        }


    }
}
