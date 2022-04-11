package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import testbase.TestBase;

public class TooltipTest extends TestBase {

    @Test
    public void shouldSeeTextFromTooltip() {
        driver.get("https://seleniumui.moderntester.pl/tooltip.php");
        String tooltipText = driver.findElement(By.id("age")).getAttribute("title");
        System.out.println(tooltipText);
    }
}
