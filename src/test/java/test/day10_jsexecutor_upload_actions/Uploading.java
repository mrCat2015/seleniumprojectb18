package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class Uploading {

    @Test
    public void uploading_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:/Users/WS1/Desktop/test");
        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-submit"));
        fileUpload.click();
        WebElement uploadedMessage = Driver.getDriver().findElement(By.xpath("//div[@class='example']/h3"));
    }




}
