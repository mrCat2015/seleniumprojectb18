package test.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class TC16_Hover_Test {

    @Test
    public void tc16_hover_test(){
        //TC	#16:	Hover	Test
        // 1.Go	to	https://demos.telerik.com/kendo-ui/dragdrop/index
        // 2.Drag	and	drop	the	small	circle	to	bigger	circle.
        // 3.Assert:
        //    -Text	in	big	circle	changed to:	“You did great

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement bigCircle  = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCircle, bigCircle).perform();

        String expected = "You did great!";
        Assert.assertEquals(bigCircle.getText(), expected);
    }
}
