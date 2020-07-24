package test.day04_FindElements_checkbox_radio;
/*
TC #02: FINDELEMENTS_APPLE
1.Open Chrome browser
2.Go to https://www.apple.com
3.Click to iPhone
4.Print out the texts of all links
5.Print out how many link is missing text
6.Print out how many link has text
7.Print out how many total link
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_AppleFindElement {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //2. Go to https://www.apple.com
        driver.get("https://www.apple.com");
        //3. Click to iPhone
        //locating the iphone link with xpath
        WebElement iphoneLink = driver.findElement(By.xpath("//span[.='iPhone']/.."));
        //clicking to the iphone link we just located

        //Thread.sleep(2000);
        iphoneLink.click();
        //4. Print out the texts of all links
        //we need to locate all of the links on the page
        //body//a --> will return all of the links INSIDE OF <body>
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        int linkWithOutLink = 0;
        int linkWithLink = 0;

        for (WebElement link : allLinks){
            String textOfLinks = link.getText();
            System.out.println(textOfLinks);
            if(textOfLinks.isEmpty()){
                linkWithOutLink++;
            }else {
                linkWithLink++;
            }
        }
        System.out.println("The number of links that does NOT have text: " + linkWithOutLink);

        //5. Print out how many link is missing text
        System.out.println("The number of links that have text: " + linkWithLink);
        //6. Print out how many link has text
        System.out.println("Total links on this page: "+allLinks.size());
        //7. Print out how many total link

    }
}
