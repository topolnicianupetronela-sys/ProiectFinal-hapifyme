package context;

import pages.LoginPage;
import pages.ProfilePage;
import pages.PostPage;
import pages.RegisterPage;

public class TestContext {

    private LoginPage loginPage;
    private ProfilePage profilePage;
    private PostPage postPage;
    private RegisterPage registerPage;

    private String generatedEmail;
    private String createdPostContent;

    public TestContext() {
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        postPage = new PostPage();
        registerPage = new RegisterPage();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public ProfilePage getProfilePage() {
        return profilePage;
    }

    public PostPage getPostPage() {
        return postPage;
    }

    public RegisterPage getRegisterPage() {
        return registerPage;
    }

    public String getGeneratedEmail() {
        return generatedEmail;
    }

    public void setGeneratedEmail(String email) {
        this.generatedEmail = email;
    }

    public String getCreatedPostContent() {
        return createdPostContent;
    }

    public void setCreatedPostContent(String content) {
        this.createdPostContent = content;
    }
}