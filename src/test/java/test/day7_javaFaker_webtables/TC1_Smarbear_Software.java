package test.day7_javaFaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC1_Smarbear_Software {
    /*


     */

    WebDriver driver;
    @BeforeMethod
    //TC #1: Smartbear software link verification
    //1. Open browser
    //2. Go to website:
    //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        public void SetUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //3. Enter username: "Tester"
        WebElement inputUserName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        inputUserName.sendKeys("Tester");

        //4. Enter password: "test"
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");

        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();


    }
    @Test
    public void p1_smartbear_login_test(){

        //6. Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        int expectedNumberofLinks = 6;
        int actualNumberOfLinks = allLinks.size();

        Assert.assertEquals(expectedNumberofLinks, actualNumberOfLinks);


        //7. Print out each link text on this page

        for(WebElement link: allLinks){
            System.out.println(link.getText());
        }
    }

    @Test
    public void p2_smartber_order_placing ()throws Exception{
        //6. Click on Order
        WebElement orderButton = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderButton.click();

        //7. Select familyAlbum from product, set quantity to 2
        Select productDropdown = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        productDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
       // quantity.clear(); //just deletes if there is any existing input in the input
        Thread.sleep(2000);
        quantity.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
        quantity.sendKeys("2");


        //8. Click to "Calculate" button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@type='submit']"));
        calculateButton.click();

        //9. Fill address Info with JavaFaker
        WebElement inputCustomerName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement inputStreet = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement inputCity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement inputState = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement inputZip = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        Faker faker = new Faker();
        inputCustomerName.sendKeys(faker.name().fullName());
        inputStreet.sendKeys(faker.address().streetAddress());
        inputCity.sendKeys(faker.address().city());
        inputState.sendKeys(faker.address().state());
        inputZip.sendKeys(faker.address().zipCode().replaceAll("-",""));

        // Generate: name,street,city,state,zip code

        WebElement visaRadioButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visaRadioButton.click();

        //10. Click on "visa" radio button
        WebElement inputCarNum = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        WebElement inputExpireDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));

        //11. Generate card number using JavaFaker
        inputCarNum.sendKeys(faker.finance().creditCard().replaceAll("-", ""));
        inputExpireDate.sendKeys("12/25");

        //12. Click on "Process"
        WebElement processButton = driver.findElement(By.xpath("//a[.='Process']"));
        processButton.click();


        //13.Verify success message "New order has been successfully added."
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        Assert.assertTrue(successMessage.isDisplayed());


    }






}
