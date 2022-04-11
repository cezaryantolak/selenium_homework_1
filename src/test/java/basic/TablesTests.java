package basic;

import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;

public class TablesTests extends TestBase {

    @Test
    public void shouldPrintSpecifMountains() {
        driver.get("https://seleniumui.moderntester.pl/table.php");
        List<WebElement> tableRows = driver.findElements(By.cssSelector("tbody tr"));
        assertThat(tableRows.size(), greaterThan(0));


        for (WebElement row : tableRows) {

            String rank = row.findElements(By.cssSelector("th")).get(0).getText();
            String peakName = row.findElements(By.cssSelector("td")).get(0).getText();
            String range = row.findElements(By.cssSelector("td")).get(1).getText();
            String state = row.findElements(By.cssSelector("td")).get(2).getText();
            String height = row.findElements(By.cssSelector("td")).get(3).getText();

            if (state.contains("Switzerland") && Integer.parseInt(height) > 4000) {
                System.out.println(rank + ". " + peakName + " " + "(" + range + ")");
            }
        }
    }
}
