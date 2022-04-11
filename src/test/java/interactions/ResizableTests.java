package interactions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testbase.TestBase;

public class ResizableTests extends TestBase {

    @Test
    public void shouldResizeObjectToRight() {
        driver.get("https://seleniumui.moderntester.pl/resizable.php");
        WebElement rightEdge = driver.findElement(By.className("ui-resizable-e"));


        Actions actions = new Actions(driver);
        actions.clickAndHold(rightEdge)
                .moveByOffset(-10,0)
                .release()
                .perform();
    }
    @Test
    public void shouldResizeObjectToBottom() {
        driver.get("https://seleniumui.moderntester.pl/resizable.php");
        WebElement rightEdge = driver.findElement(By.className("ui-resizable-s"));


        Actions actions = new Actions(driver);
        actions.clickAndHold(rightEdge)
                .moveByOffset(0,-10)
                .release()
                .perform();
    }
    @Test
    public void shouldResizeObjectRightAndBottom() {
        driver.get("https://seleniumui.moderntester.pl/resizable.php");
        WebElement rightEdge = driver.findElement(By.className("ui-resizable-se"));


        Actions actions = new Actions(driver);
        actions.clickAndHold(rightEdge)
                .moveByOffset(10,10)
                .release()
                .perform();
    }
}
