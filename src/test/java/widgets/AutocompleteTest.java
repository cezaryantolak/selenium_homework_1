package widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import java.nio.file.FileStore;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;

public class AutocompleteTest extends TestBase {

    @Test
    public void shouldPrintResults() {
        driver.get("https://seleniumui.moderntester.pl/autocomplete.php");
        WebElement searchInput = driver.findElement(By.id("search"));
        searchInput.sendKeys("a");
        List<WebElement> searchResults = driver.findElements(By.id("ui-id-1"));
        assertThat(searchResults.size(), greaterThan(0));

        for (WebElement result : searchResults) {
            System.out.println(result.getText());
        }
        WebElement selectedOption = searchResults.get(new Random().nextInt(searchResults.size()));
        String selectedOptionText = selectedOption.getText();
        selectedOption.click();
        assertThat("Selection not as expected", searchInput.getAttribute("value").equals(selectedOptionText));
    }
}
