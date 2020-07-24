package test.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_GoogleTitleVerification {
    public static void main(String[] args) {

        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Google title verification PASSED");
        }else{
            System.out.println("Google title verification FAILED");
        }

    }
}
