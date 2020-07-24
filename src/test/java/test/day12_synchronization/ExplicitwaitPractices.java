package test.day12_synchronization;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading1Page;
import pages.Loading7Page;
import utilities.Driver;

public class ExplicitwaitPractices {
    //TC#40: Dynamically Loaded Page Elements 7
    // 1.Go to http://practice.cybertekschool.com/dynamic_loading/7
    // 2.Wait until title is “Dynamic Title”
    // 3.Assert : Message “Done” is displayed.
    // 4.Assert : Image is displayed.
    // Note: Follow POM

    @Test
    public void tc40_dynamic_title(){
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");
        Loading7Page loading7Page = new Loading7Page();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        Assert.assertTrue(loading7Page.doneMessage.isDisplayed());
        Assert.assertTrue(loading7Page.spongeBobImage.isDisplayed());


    }

    @Test
    public void tc41_dynamic_title(){
        //TC#41: Dynamically Loaded Page Elements 1
        // 1.Go to http://practice.cybertekschool.com/dynamic_loading/1
        // 2.Click to start
        // 3.Wait until loading bar disappears
        // 4.Assert username input box is displayed
        // 5.Enter username: to msmith
        // 6.Enter password: incorrect password
        // 7.Click to Submit button
        // 8.Assert “Your username is invalid!” text is displayed.
        // Note: Follow POM

        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");
        Loading1Page loading1Page = new Loading1Page();
        loading1Page.startButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(loading1Page.loading));

        Assert.assertTrue(loading1Page.userName.isDisplayed());
        loading1Page.userName.sendKeys("msmith");
        loading1Page.password.sendKeys("incorrect");
        loading1Page.submitButton.click();
        Assert.assertTrue(loading1Page.message.isDisplayed());

    }
}

