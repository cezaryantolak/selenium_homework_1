package other;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import testbase.TestBase;

import java.io.File;


public class HighSiteTest extends TestBase {

    @Test
    public void shouldScrollDownUntilSubmitVisible() {
        driver.get("https://seleniumui.moderntester.pl/high-site.php");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (!isElementVisible("#scroll-button")) {
            js.executeScript("window.scrollBy(0,50)");
        }
        takeScreenShot("buttonScreenshot");

    }
    public boolean isElementVisible(String element) {
        try {
            return driver.findElement(By.cssSelector(element)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    //przyznaję, że znalazłem to rozwiązanie w internecie. Nie mam pojęcia dlaczego to nie działa.
    //Generalnie to jak widzę inne opcje robienia screenshotów w Javie (przy użyciu Robota), to jest to straszne..
    public void takeScreenShot(String fileName) {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("src/main/resources/files/" + fileName + ".png");
    }
}

