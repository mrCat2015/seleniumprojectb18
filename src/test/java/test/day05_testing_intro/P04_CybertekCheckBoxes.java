package test.day05_testing_intro;
/*
Practice:	Cybertek	Checkboxes
1.Go	to	http://practice.cybertekschool.com/checkboxes
2.Confirm	checkbox	#1	is	NOT	selected	by	default
3.Confirm	checkbox	#2	is	SELECTED	by	default.
4.Click	checkbox	#1	to	select	it.
5.Click	checkbox	#2	to	deselect	it.
6.Confirm	checkbox	#1	is	SELECTED.
7.Confirm	checkbox	#2	is	NOT
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class P04_CybertekCheckBoxes {
    public static void main(String[] args) throws Exception{
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement box1 = driver.findElement(By.xpath("(//input[@type = 'checkbox'])[1]"));


        if(!box1.isSelected()){
            System.out.println("Checkbox #1 is not selected. Verification PASSED!!!");
        }else{
            System.out.println("Checkbox #1 is selected. Verification FAILED!!!");
        }

        WebElement box2 = driver.findElement(By.xpath("(//input[@type = 'checkbox'])[2]"));

        if(box2.isSelected()){
            System.out.println("Checkbox #2 is selected. Verification PASSED!!!");
        }else{
            System.out.println("Checkbox #2 is NOT selected. Verification FAILED!!!");
        }
        Thread.sleep(3000);
        box1.click();
        Thread.sleep(3000);
        box2.click();

        if(box1.isSelected()){
            System.out.println("Checkbox #1 is selected. Verification PASSED!!!");
        }else{
            System.out.println("Checkbox #1 is NOT selected. Verification FAILED!!!");
        }

        if(!box2.isSelected()){
            System.out.println("Checkbox #2 is NOT selected. Verification PASSED!!!");
        }else{
            System.out.println("Checkbox #2 is selected. Verification FAILED!!!");
        }

    }
}
