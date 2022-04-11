package interactions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testbase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;

public class DroppableTests extends TestBase {

    @Test
    public void shouldDragAndDrop() {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .perform();

        assertThat("Not dropped", drop.getText().equals("Dropped!"));
    }
}
