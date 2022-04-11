package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.TestBase;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;

public class SelectableTest extends TestBase {

    @Test
    public void shouldChooseRandomSpeed() {
        driver.get("https://seleniumui.moderntester.pl/selectmenu.php");

        WebElement speedButton = driver.findElement(By.id("speed-button"));
        speedButton.click();

        List<WebElement> speedOptions = driver.findElements(By.id("speed-menu"));
        assertThat(speedOptions.size(), greaterThan(0));
        WebElement chosenSpeed = speedOptions.get(new Random().nextInt(speedOptions.size()));
        chosenSpeed.click();
    }
    @Test
    public void shouldChooseFileByText() {
        driver.get("https://seleniumui.moderntester.pl/selectmenu.php");

        WebElement filesButton = driver.findElement(By.id("files-button"));
        filesButton.click();

        WebElement fileOptions = driver.findElement(By.id("files"));
        Select selectFile = new Select(fileOptions);
        selectFile.selectByVisibleText("jQuery.js");
    }
    @Test
    public void shouldChooseNumberByIndex() {
        driver.get("https://seleniumui.moderntester.pl/selectmenu.php");

        WebElement numbersButton = driver.findElement(By.id("number-button"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        numbersButton.click();
        wait.until(ExpectedConditions.attributeToBe(numbersButton, "aria-expanded", "true"));

        WebElement numberOptions = driver.findElement(By.id("number"));
        Select selectFile = new Select(numberOptions);
        selectFile.selectByIndex(1);
    }
    @Test
    public void shouldSelectRandomTitle(){
        driver.get("https://seleniumui.moderntester.pl/selectmenu.php");
        WebElement titleButton = driver.findElement(By.id("salutation-button"));
        titleButton.click();

        List<WebElement> titleOptions = driver.findElements(By.id("salutation-menu"));
        assertThat(titleOptions.size(), greaterThan(0));
        WebElement chosenTitle = titleOptions.get(new Random().nextInt(titleOptions.size()));
        chosenTitle.click();
    }
}
