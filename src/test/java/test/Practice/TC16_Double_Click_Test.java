package test.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class TC16_Double_Click_Test {

    Actions actions;

    @Test
    public void tc16_double_click_test(){

        //TC #16: Double	ClickTest
        // 1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        // 2.Switch	to	iframe.
        // 3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
        // 4.Assert:	Text’s	“style”	attribute	value contains "red"

        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().manage().window().maximize();

        Driver.getDriver().switchTo().frame("iframeResult");
        WebElement textToDoubleClick = Driver.getDriver().findElement(By.id("demo"));
        actions = new Actions(Driver.getDriver());
        actions.doubleClick(textToDoubleClick).perform();

        String actual = textToDoubleClick.getAttribute("style");
        String exspected = "color: red;";

        Assert.assertTrue(actual.equals(exspected));


    }
}
