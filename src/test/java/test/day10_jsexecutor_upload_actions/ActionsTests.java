package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class ActionsTests {

    @Test
    public void hover_over_test1() throws Exception{
        Driver.getDriver().get("https://www.amazon.com");
        //1- Create the instance of Actions class
        //2- Pass the current driver instance
        Actions actions  = new Actions(Driver.getDriver());

        //3- Locate the web element to hover over
        WebElement languageOptions = Driver.getDriver().findElement(By.id("icp-nav-flyout"));

        Thread.sleep(3000);

        //4- Using actions, hover over to the Language options
        actions.moveToElement(languageOptions).perform();



    }

    @Test
    public void tc15_hover_test() throws Exception{
        //TC	#15:	Hover	Test
        // 1.Go	to	http://practice.cybertekschool.com/hovers
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        // 2.Hover	over	to	first	image

        WebElement firstImage = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement secondImage = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement thirdImage = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]"));
        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(firstImage).perform();
        Assert.assertTrue(user1.isDisplayed());
        Thread.sleep(1000);


        actions.moveToElement(secondImage).perform();
        Assert.assertTrue(user2.isDisplayed());
        Thread.sleep(1000);



        actions.moveToElement(thirdImage).perform();
        Assert.assertTrue(user3.isDisplayed());
        Thread.sleep(1000);




        // Assert.assertTrue(te);




        // 3.Assert:	a.“name:	user1”	is	displayed
        // 4.Hover	over	to	second	image
        // 5.Assert:	a.“name:	user2”	is	displayed
        // 6.Hover	over	to	third	image
        // 7.Confirm:	a.“name:	user3”	is	di
    }


}
