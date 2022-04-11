package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.TestBase;

import java.time.Duration;

public class MenuTest extends TestBase {

    @Test
    public void shouldOpenModernJazz() {

        driver.get("https://seleniumui.moderntester.pl/menu-item.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("ui-id-9")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-13")));
        driver.findElement(By.id("ui-id-13")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-16")));
        driver.findElement(By.id("ui-id-16")).click();
    }
}
