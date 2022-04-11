package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.TestBase;

import java.time.Duration;

public class AccordionTest extends TestBase {

    @Test
    public void shouldPrintTextFromEverySection() {
        driver.get("https://seleniumui.moderntester.pl/accordion.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement textBoxOne = driver.findElement(By.id("ui-id-2"));
        //driver.findElement(By.id("ui-id-1")).click();
        wait.until(ExpectedConditions.attributeToBe(textBoxOne, "aria-hidden", "false"));
        System.out.println(textBoxOne.getText());

        WebElement textBoxTwo = driver.findElement(By.id("ui-id-4"));
        driver.findElement(By.id("ui-id-3")).click();
        wait.until(ExpectedConditions.attributeToBe(textBoxTwo, "aria-hidden", "false"));
        System.out.println(textBoxOne.getText());

        WebElement textBoxThree = driver.findElement(By.id("ui-id-6"));
        driver.findElement(By.id("ui-id-5")).click();
        wait.until(ExpectedConditions.attributeToBe(textBoxThree, "aria-hidden", "false"));
        System.out.println(textBoxOne.getText());

        WebElement textBoxFour = driver.findElement(By.id("ui-id-8"));
        driver.findElement(By.id("ui-id-7")).click();
        wait.until(ExpectedConditions.attributeToBe(textBoxFour, "aria-hidden", "false"));
        System.out.println(textBoxOne.getText());


    }
}
