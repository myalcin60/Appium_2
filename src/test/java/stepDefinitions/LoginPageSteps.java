package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utilities.Driver;

import static org.junit.Assert.assertTrue;


public class LoginPageSteps {

    LoginPage loginPage = new LoginPage();

    @Given("Kullanici kitap yurdu uygulamasini acar")
    public void kullanici_kitap_yurdu_uygulamasini_acar()  {

    }
    @Then("Kullanici acilan sayfada kitapyurdu metninin gorundugunu dogrular")
    public void kullanici_acilan_sayfada_kitapyurdu_metninin_gorundugunu_dogrular() {
        assertTrue(loginPage.kitapyurdu.isDisplayed());
    }

}
