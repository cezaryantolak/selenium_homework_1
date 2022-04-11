package basic;

import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.TestBase;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AlertTests extends TestBase {

    @Test
    public void shouldPressButton() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        driver.findElement(By.id("simple-alert")).click();
        String actualTxt = driver.switchTo().alert().getText();
        assertThat(actualTxt, equalTo("OK button pressed"));
    }
    @Test
    public void shouldShowNewAnnouncementWithName() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        driver.findElement(By.id("prompt-alert")).click();
        driver.switchTo().alert().sendKeys("Lord Vader");
        driver.switchTo().alert().accept();
        String actualTxt = driver.findElement(By.id("prompt-label")).getText();
        assertThat(actualTxt, equalTo("Hello Lord Vader! How are you today?"));
    }
    @Test
    public void shouldConfirmAndCancelAfterClick() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        driver.findElement(By.id("confirm-alert")).click();
        driver.switchTo().alert().accept();
        String confirmTxt = driver.findElement(By.id("confirm-label")).getText();
        assertThat(confirmTxt, equalTo("You pressed OK!"));
        driver.findElement(By.id("confirm-alert")).click();
        driver.switchTo().alert().dismiss();
        String cancelTxt = driver.findElement(By.id("confirm-label")).getText();
        assertThat(cancelTxt, equalTo("You pressed Cancel!"));
    }
    @Test
    public void shouldShowAlertAfterDelay() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        driver.findElement(By.id("delayed-alert")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        String actualTxt = driver.findElement(By.id("delayed-alert-label")).getText();
        assertThat(actualTxt, equalTo("OK button pressed"));
    }
}
