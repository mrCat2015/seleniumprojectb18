package test.day01_selenium_intro;
/*
TC	#2:	Cybertek	verifications
1.Open	Chrome	browser
2.Go	to	https://practice.cybertekschool.com
3.Verify	URL	containsExpected:	cybertekschool
4.Verify	title:	Expected:	Practice
http://practice.cybertekschool.com/
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_Cybertek_Verifications {
    public static void main(String[] args) {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
        String actualTitle = driver.getTitle();
        String expectationTitle = "cybertekschool";

            if(actualTitle.contains(expectationTitle)){
                System.out.println("Practice");
            }else{
                System.out.println("Failed");
            }
 
    }
}
