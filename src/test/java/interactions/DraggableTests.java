package interactions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testbase.TestBase;

public class DraggableTests extends TestBase {

    @ParameterizedTest
    @CsvSource({"upper right, -200, -200",
                "bottom right, 1000, 300",
                "centre, 400, 180",
                "bottom left, -200, 300"})
    public void shouldMoveObjectToDirections(String direction, int x, int y) {
        driver.get("https://seleniumui.moderntester.pl/draggable.php");
        WebElement drag = driver.findElement(By.id("draggable"));


        Actions actions = new Actions(driver);
        actions.clickAndHold(drag)
                .moveByOffset(x,y)
                .release()
                .perform();
        System.out.println("Square moved to new position: " + direction);
    }

}
