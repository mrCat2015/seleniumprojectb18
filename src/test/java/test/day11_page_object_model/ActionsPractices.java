package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class ActionsPractices {

    @Test
    public void scrolling_with_actions() throws Exception{
        Driver.getDriver().get("http://practice.cybertekschool.com/");
        Driver.getDriver().manage().window().maximize();

        Actions actions = new Actions(Driver.getDriver());
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        Thread.sleep(2000);

        actions.moveToElement(cybertekSchoolLink).perform();


    }






}
