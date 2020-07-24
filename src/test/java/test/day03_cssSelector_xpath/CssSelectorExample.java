package test.day03_cssSelector_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class CssSelectorExample {
    public static void main(String[] args) throws InterruptedException {
       WebDriver driver = WebDriverFactory.getDriver("chrome");
       driver.get("https://amazon.com");
       WebElement amazonSearch = driver.findElement(By.cssSelector("input[tabindex='19']"));
       amazonSearch.sendKeys("wooden spoon" + Keys.ENTER);

       String actualTitle = driver.getTitle();
       String expectInTitle = "wooden spoon";

       Thread.sleep(1000);

       if(actualTitle.contains(expectInTitle)){
           System.out.println("TITLE verification PASSED");
       }else{
           System.out.println("title verification FAILED");
       }



    }
}
