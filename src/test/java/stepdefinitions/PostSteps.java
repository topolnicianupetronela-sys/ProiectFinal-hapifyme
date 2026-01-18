package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PostPage;

public class PostSteps {

    private final PostPage postPage;

    public PostSteps(TestContext context) {
        this.postPage = context.getPostPage(); // direct din TestContext
    }

    @When("utilizatorul creează o postare cu mesajul {string}")
    public void createPostWithMessage(String message) {
        postPage.openPage();
        postPage.createPost(message);
    }

    @Then("postarea ar trebui să fie afișată cu textul {string}")
    public void verifyPostWithText(String message) {
        postPage.verifyPostText(message);
    }
}