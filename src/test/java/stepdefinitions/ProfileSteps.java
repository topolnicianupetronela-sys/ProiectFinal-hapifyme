package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.*;
import pages.ProfilePage;

import static com.codeborne.selenide.Condition.text;

public class ProfileSteps {

    private final TestContext context;
    private final ProfilePage profilePage;

    public ProfileSteps(TestContext context) {
        this.context = context;
        this.profilePage = context.getProfilePage(); // direct din TestContext
    }

    // Căutare profil
    @When("utilizatorul caută {string} în bara de navigare")
    public void searchUser(String query) {
        profilePage.searchUser(query);
    }

    @Then("ar trebui să vadă o listă de rezultate care conține {string}")
    public void shouldSeeResults(String expected) {
        // verificăm că rezultatul afișat conține textul căutat
        profilePage.listResults.shouldHave(text(expected));
    }

}