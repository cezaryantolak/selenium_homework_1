package interactions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import testbase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;

public class SelectableTest extends TestBase {

    @Test
    void shouldSelectNumbersOneThreeFour() {
        driver.get("https://seleniumui.moderntester.pl/selectable.php");
        WebElement item1 = driver.findElement(By.cssSelector("#selectable li:first-child"));
        WebElement item2 = driver.findElement(By.cssSelector("#selectable li:nth-child(3)"));
        WebElement item3 = driver.findElement(By.cssSelector("#selectable li:nth-child(4)"));
        WebElement feedback = driver.findElement(By.cssSelector("#feedback"));

        Actions actionProvider = new Actions(driver);
        Action keydown = actionProvider.keyDown(Keys.CONTROL)
                .moveToElement(item1).click()
                .moveToElement(item2).click()
                .moveToElement(item3).click().build();

        keydown.perform();

        assertThat("Wrong feedback", feedback.getText().equals("You've selected: #1 #3 #4."));
    }
}
