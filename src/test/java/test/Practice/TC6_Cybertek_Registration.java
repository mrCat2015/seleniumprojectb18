package test.Practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC6_Cybertek_Registration {
    //TC#6: Cybertek registration form confirmationNote: Use JavaFaker when possible.
    // 1.Open browser
    // 2.Go to website: http://practice.cybertekschool.com/registration_form
    // 3.Enter first name
    // 4.Enter last name
    // 5.Enter username
    // 6.Enter email address
    // 7.Enter password
    // 8.Enter phone number
    // 9.Select a gender from radio buttons
    // 10.Enter date of birth
    // 11.Select Department/Office
    // 12.Select Job Title
    // 13.Select programming language from checkboxes1
    // 14.Clickto sign up button
    // 15.Verify success message “You’ve successfully completed registration.”is displayed.
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void registration_firm() throws Exception{
        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userName = driver.findElement(By.xpath("(//input[@class='form-control'])[3]"));
        userName.sendKeys(faker.name().username().replaceAll(".", "0"));

        WebElement emailAddress = driver.findElement(By.xpath("(//input[@class='form-control'])[4]"));
        emailAddress.sendKeys("marina.makarova.zab@gmail.com");

        WebElement password = driver.findElement(By.xpath("(//input[@class='form-control'])[5]"));
        password.sendKeys("1259863gtyQ");

        WebElement phoneNumber = driver.findElement(By.xpath("(//input[@class='form-control'])[6]"));
        phoneNumber.sendKeys(faker.phoneNumber().phoneNumber());

        WebElement gender = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        gender.click();

        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
        dateOfBirth.sendKeys("05/07/1985");

        Select departmentDropdown = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        Thread.sleep(3000);
        departmentDropdown.selectByVisibleText("Department of Engineering");

        Select jobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        Thread.sleep(3000);
        jobTitle.selectByIndex(4);

        WebElement programLang = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        programLang.click();

        WebElement signUpButton = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
        signUpButton.click();

        String expect = "You've successfully completed registration!";
        String actual = driver.findElement(By.xpath("//div/p")).getText();

        Assert.assertEquals(expect, actual);





    }
}
