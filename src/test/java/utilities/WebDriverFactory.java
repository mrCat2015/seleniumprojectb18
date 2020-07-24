package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String arg){

        if(arg.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if(arg.equalsIgnoreCase("FireFox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else{
            System.out.println("Given browser type does not exist. ");
            return null;
        }

    }
}
