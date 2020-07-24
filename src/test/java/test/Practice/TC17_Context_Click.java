package test.Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class TC17_Context_Click {
    //TC #17: Context Click–HOMEWORK
    // 1.Go	to	https://the-internet.herokuapp.com/context_menu
    // 2.Right	click to the box.
    // 3.Alert	will open.
    // 4.Accept	alertNo	assertion needed for this practice.

    @Test
    public void tc17_context_click(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        Driver.getDriver().manage().window().maximize();
        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(box).perform();

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();




    }
}
