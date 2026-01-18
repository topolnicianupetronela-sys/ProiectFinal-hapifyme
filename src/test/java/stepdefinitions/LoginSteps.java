package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("utilizatorul deschide pagina de login {string}")
    public void openPage(String url) {
        loginPage.openPage();
    }

    @When("utilizatorul introduce emailul {string}")
    public void enterEmail(String email) {
        loginPage.enterEmail(email);
    }

    @And("utilizatorul introduce parola {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("utilizatorul apasă butonul de login")
    public void clickLogin() {
        loginPage.clickLoginButton();
    }

    @Then("utilizatorul ar trebui să fie redirecționat către homepage")
    public void verifyHomepage() {
        loginPage.verifyHomePageLoaded();
    }

    @Then("utilizatorul ar trebui să vadă un mesaj de eroare {string}")
    public void verifyErrorMessage(String expectedError) {
        loginPage.verifyErrorMessage(expectedError);
    }
}