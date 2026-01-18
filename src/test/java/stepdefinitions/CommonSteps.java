package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import pages.LoginPage;

public class CommonSteps {

    private final LoginPage loginPage;

    public CommonSteps(TestContext context) {
        this.loginPage = context.getLoginPage();
    }

    @Given("utilizatorul este logat în aplicație")
    public void performBackgroundLogin() {
        loginPage.openPage();
        loginPage.login("topolnicianu.petronela@gmail.com", "Test!123");
    }
}