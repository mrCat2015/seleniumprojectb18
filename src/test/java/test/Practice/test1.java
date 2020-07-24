package test.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class test1 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
      //  driver.findElement(By.xpath("//a[@href ='/autocomplete']")).click();
        driver.findElement(By.xpath("//a[@href ='/autocomplete']")).click();

    }
}

