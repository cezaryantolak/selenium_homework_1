package basic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import testbase.TestBase;

public class IframesTests extends TestBase {

    @Test
    public void shouldFillIframes() {
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
        driver.switchTo().frame("iframe1");
        driver.findElement(By.id("inputFirstName3")).sendKeys("Adam");
        driver.findElement(By.id("inputSurname3")).sendKeys("Kowalski");
        driver.switchTo().parentFrame();

        driver.switchTo().frame("iframe2");
        driver.findElement(By.id("inputLogin")).sendKeys("dominator2");
        driver.findElement(By.id("inputPassword")).sendKeys("hasło1234");

        Select continents = new Select(driver.findElement(By.id("inlineFormCustomSelectPref")));
        continents.selectByValue("asia");

        Select yearsExperience = new Select(driver.findElement(By.className("col-sm-10")));
        yearsExperience.selectByIndex(3);

        driver.switchTo().defaultContent();
        driver.findElement(By.className("nav-link dropdown-toggle")).click();



    }

}
