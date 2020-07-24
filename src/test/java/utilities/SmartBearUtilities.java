package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {
    public static void login(WebDriver driver){
        //3. Enter username: “Tester”
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUsername.sendKeys("Tester");
        //4. Enter password: “test”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");
        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
    }



    //PRACTICE #4: Method: verifyOrder
    // •Create a method named verifyOrder in SmartBearUtils class.
    // •Method takes WebDriver object and String(name).
    // •Method should verify if given name exists in orders.
    // •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    // •Create a new TestNG test to test if the method is working as expected.

    public static void verifyOrder(WebDriver driver, String name){

        //Finding and storing all of the names in our web table in a list of web element
        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        //shirt cut iter+enter
        for (WebElement each : nameList) {
            if(each.getText().equals(name)){
                Assert.assertTrue(true);
                return;
            }

        }
        Assert.fail("The name does not exist in the List! Verification failed!" );



    }



    //Practice #5: Method: printNamesAndCities
    // •Create a method named printNamesAndCities in SmartBearUtils class.
    // •Method takes WebDriver object.
    // •This method should simply print all the names in the List of All Orders.
    // •Create a new TestNG test to test if the method is working as expected.
    // •Output should be like:
    // •Name1: name , City1: city
    // •Name2: name , City2: city
    public static void printNamesAndCities(WebDriver driver){

        //The list where we store all the names in the web table
        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        //The list where we store all the cities in the web table
        List<WebElement> citiesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]"));

        for(int i=0; i<nameList.size(); i++){
            System.out.println("Name: "+nameList.get(i).getText() + ", City: "+citiesList.get(i).getText());
        }

    }



}
