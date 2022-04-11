package widgets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;

public class ModalDialogTest extends TestBase {

    @ParameterizedTest
    @CsvFileSource(resources = "/userData.csv")
    public void shouldCreateNewUser(String name, String email, String password) {
        driver.get("https://seleniumui.moderntester.pl/modal-dialog.php");

        WebElement newUserBtn = driver.findElement(By.id("create-user"));
        newUserBtn.click();

        WebElement nameBox = driver.findElement(By.id("name"));
        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passwordBox = driver.findElement(By.id("password"));

        nameBox.clear();
        nameBox.sendKeys(name);
        emailBox.clear();
        emailBox.sendKeys(email);
        passwordBox.clear();
        passwordBox.sendKeys(password);

        driver.findElement(By.cssSelector("div .ui-dialog-buttonset button:first-child")).click();

        WebElement lastTableRow = driver.findElement(By.cssSelector("tbody tr:last-child"));
        assertThat("Name incorrect", lastTableRow.findElement(By.cssSelector("td:nth-child(1)")).getText().equals(name));
        assertThat("Email incorrect", lastTableRow.findElement(By.cssSelector("td:nth-child(2)")).getText().equals(email));
        assertThat("Password incorrect", lastTableRow.findElement(By.cssSelector("td:nth-child(3)")).getText().equals(password));
    }
}
