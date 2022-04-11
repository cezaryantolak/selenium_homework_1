package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.TestBase;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ProgressbarTest extends TestBase {

    @Test
    public void shouldShowTextAfterLoading() {

        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        WebElement progressBar = driver.findElement(By.cssSelector(".ui-progressbar-value"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(progressBar, "class",
                "ui-progressbar-complete"));

        assertThat(driver.findElement(By.cssSelector(".progress-label")).getText(), equalTo("Complete!"));
    }
}
