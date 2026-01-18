package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {

    private final SelenideElement emailField = $("[name='log_email']");
    private final SelenideElement passwordField = $("[name='log_password']");
    private final SelenideElement loginButton = $("[name='login_button']");
    private final SelenideElement postsArea = $(".posts_area");

    public void openPage() {
        open("/login_register.php"); // Folosește baseUrl din Hooks
    }

    public void enterEmail(String email) {
        emailField.setValue(email);
    }

    public void enterPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void verifyHomePageLoaded() {
        postsArea.shouldBe(visible);
    }

    public void verifyErrorMessage(String expected) {
        $("body").shouldHave(text(expected));
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

}