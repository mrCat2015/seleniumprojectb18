package test.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {
    public static void main(String[] args) throws InterruptedException {

        //1- This line creates the connection between driver and selenium.
        // And sets up the driver.
        WebDriverManager.chromiumdriver().setup();

        //2- Creating the instance of ChromeDriver to be able to do action on ChromeBrowser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();//maximizes the browser page after opening it


        //3- we get google.com
        //String googleUrl = "http://www.google.com";
        driver.get("http://www.google.com");
        System.out.println("driver.getTitle()-->"+driver.getTitle());
        System.out.println("driver.getCurrentUrl()-->"+driver.getCurrentUrl());
        //BROWSER NAVIGATIONS
        //this line will take user to the previous page

        Thread.sleep(2000);//this line adds 2000milliseconds of wait = 2seconds

        driver.navigate().back();
        //Thread.sleep is being added just to be able to see selenium movements

        Thread.sleep(2000);
        driver.navigate().forward(); //This line will go to next page


        Thread.sleep(2000);
        driver.navigate().refresh();//This line will refresh the page

        driver.get("http://www.facebook.com");
        System.out.println("driver.getTitle()-->"+ driver.getTitle());
        System.out.println("driver.getCurrentUrl()-->"+driver.getCurrentUrl());

        System.out.println(driver.getPageSource());

        driver.close();









    }


}
