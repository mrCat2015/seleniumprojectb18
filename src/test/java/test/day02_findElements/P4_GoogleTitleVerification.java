package test.day02_findElements;
/*
TC#4:
Google	search
1-Open	a	chrome	browser
2-Go	to:	https://google.com
3-Write	“apple”	in	search	box
4-Click	google	search	button
5-Verify	title:Expected:	Title	should	start	with	“apple" world
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleTitleVerification {
    public static void main(String[] args) {
        //1-Open	a	chrome	browser
        //alt + enter --> for manual importing
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2-Go	to:	https://google.com
        driver.get("https://google.com");

        //3-Write	“apple”	in	search	box
        //driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);
        driver.findElement(By.name("q")).sendKeys("apple");

        //4-Click	google	search	button
        driver.findElement(By.name("btnK")).click();


        //5-Verify	title:Expected:	Title	should	start	with	“apple" world

        String actualTitle = driver.getTitle();
        String expectedInTitle = "apple";

        if(actualTitle.startsWith(expectedInTitle)){
            System.out.println("Google searche title verification PASSED!!!");
        }else{
            System.out.println("Google searche title verification FAILED!!!");
        }






    }
}
