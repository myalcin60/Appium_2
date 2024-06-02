package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.KampanyalarPage;
import pages.LoginPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.driver;


public class KampanyalarSteps {

    LoginPage loginPage = new LoginPage();
    KampanyalarPage kampanyalarPage = new KampanyalarPage();

    @Then("Kullanici acilan sayfada Kampanyalara tiklar")
    public void kullanici_acilan_sayfada_kampanyalara_tiklar() {
        loginPage.kampanyalar.click();
    }
    @Then("Kullanici One Cikan Kampanyalar yazisinin goruntulendigini dogrular")
    public void kullanici_one_cikan_kampanyalar_yazisinin_goruntulendigini_dogrular() {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

        assertTrue(kampanyalarPage.oneCikanKampanyalar.isDisplayed());
    }

}
