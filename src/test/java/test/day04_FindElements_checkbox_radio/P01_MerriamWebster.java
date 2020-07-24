package test.day04_FindElements_checkbox_radio;
/*
TC #0: FINDELEMENTS
1.Open Chrome browser
2.Go to https://www.merriam-webster.com/
3.Print out the texts of all links
4.Print out how many link is missing text
5.Print out how many link has text
6.Print out how many total link
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P01_MerriamWebster {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.merriam-webster.com/");

        //3.Print out the texts of all links
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        //alt + enter

        //4.Print out how many link is missing text

        int linkWithOutLink = 0;
        int linkWithLink = 0;

        for(WebElement eachLink: listOfLinks){
            String textOfEachLink = eachLink.getText();
            if(textOfEachLink.isEmpty()){
                linkWithOutLink++;
            }else{
                System.out.println(eachLink.getText());
                linkWithLink++;
            }
        }

            //4.Print out how many link is missing text
            System.out.println("The number of link that does NOT have text: "+linkWithOutLink);

            //5.Print out how many link has text
            System.out.println("The number of link that has text: "+linkWithLink);

        System.out.println("Total links: "+ listOfLinks.size());

    }
}
