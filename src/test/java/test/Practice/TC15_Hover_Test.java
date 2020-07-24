package test.Practice;

import org.testng.annotations.BeforeMethod;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class TC15_Hover_Test {
    //TC #15: Hover Test
    // 1.Go	to	http://practice.cybertekschool.com/hovers
    // 2.Hover over	to	first image
    // 3.Assert: a.“name: user1” is	displayed
    // 4.Hover over to	second	image
    // 5.Assert: a.“name: user2” is	displayed
    // 6.Hover over	to	third image
    // 7.Confirm: a.“name: user3” is displayed

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

}
