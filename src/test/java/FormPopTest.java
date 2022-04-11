import org.junit.jupiter.api.Test;
import pages.FormPage;
import testbase.TestBase;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class FormPopTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess(){
        driver.get("https://seleniumui.moderntester.pl/form.php");
        File file = new File("src/main/resources/file.txt");

        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Dezyderiusz");
        formPage.setLastName("Bartnik");
        formPage.setEmail("d.b@ww.pl");
        formPage.setAge(32);
        formPage.selectRandomProfession();
        formPage.selectRandomExperience();
        formPage.selectMale();
        formPage.selectContinent("asia");
        formPage.selectSeleniumCommand("browser-commands");
        formPage.uploadFile(file);
        formPage.submitForm();

        String message = formPage.getValidationMsg();

        assertThat(message, equalTo("Form send with success"));
    }
}
