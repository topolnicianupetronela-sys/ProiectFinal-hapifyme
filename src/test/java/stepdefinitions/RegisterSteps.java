package stepdefinitions;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;

import java.util.List;
import java.util.Map;

public class RegisterSteps {

    private final TestContext context;
    private final RegisterPage registerPage;

    public RegisterSteps(TestContext context) {
        this.context = context;
        this.registerPage = context.getRegisterPage(); // din TestContext
    }

    @And("utilizatorul accesează formularul de înregistrare")
    public void accessRegistrationForm() {
        registerPage.accessRegistrationForm();
    }

    @When("completează formularul de înregistrare:")
    public void completeRegistrationForm(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            registerPage.openPage("https://test.hapifyme.com/login_register.php");
            registerPage.accessRegistrationForm(); // click pe "Need an account?Register here!"
            registerPage.fillRegistrationForm(row.get("First Name"), row.get("Last Name"),
                    row.get("Email"), row.get("Confirm Email"), row.get("Password"), row.get("Confirm Password"));
            registerPage.submitForm();
            context.setGeneratedEmail(row.get("Email"));
        }

    }

    @Then("You're all set! Go ahead and login!")
    public void registrationSuccessMessageShouldBeDisplayed() {
        registerPage.verifySuccessMessage();
    }
}