package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SliderTest extends TestBase {

    @Test
    public void shouldMoveSliderToValue() {
        driver.get("https://seleniumui.moderntester.pl/slider.php");
        List<Integer> values = List.of(50, 80, 80, 20, 0);

        WebElement handle = driver.findElement(By.id("custom-handle"));
        int curentVaule = 0;

        for (Integer value : values) {
            while (value != Integer.parseInt(handle.getText())) {
                if (curentVaule < value) {
                    handle.sendKeys(Keys.ARROW_RIGHT);
                    curentVaule++;
                }else if (curentVaule > value) {
                    handle.sendKeys(Keys.ARROW_LEFT);
                    curentVaule--;
                }else {
                    break;
                }
            }
            assertEquals(value, Integer.parseInt(handle.getText()));
        }
    }
}
