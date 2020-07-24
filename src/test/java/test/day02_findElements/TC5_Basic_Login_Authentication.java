package test.day02_findElements;
/*
TC#5:	Basic	login	authentication
1-Open	a	chrome	browser
2-Go	to:	http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3-Verify	title	equals:Expected:	Web	Orders	Login
4-Enter	username:	Tester
5-Enter	password:	test
6-Click	“Sign	In”	button
7-Verify	titleequals:
Expected:	Web	Orders
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_Basic_Login_Authentication {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";

        if(actualTitle.contains(expectedTitle)){
            System.out.println("WEB Orders Login title verification PASSED!!!");
        }else{
            System.out.println("WEB Orders Login title verification FAILED!!!");
        }

        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        String title = "Web Orders";
        String acTitle = driver.getTitle();

        if(acTitle.contains(title)){
            System.out.println("title verification PASSED!!!");
        }else{
            System.out.println("title verification FAILED!!!");
        }

    }
}
