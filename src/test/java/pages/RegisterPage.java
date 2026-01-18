package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegisterPage {

    private SelenideElement firstNameInput = $(By.name("reg_fname"));
    private SelenideElement lastNameInput = $(By.name("reg_lname"));
    private SelenideElement emailInput = $(By.name("reg_email"));
    private SelenideElement emailInputConfirm = $(By.name("reg_email2"));
    private SelenideElement passwordInput = $(By.name("reg_password"));
    private SelenideElement passwordInputConfirm = $(By.name("reg_password2"));
    private SelenideElement submitBtn = $(By.name("register_button"));

    public void openPage(String url) {
        open(url);
    }

    public void accessRegistrationForm() {
        $("#signup").click();
    }

    public void fillRegistrationForm(String firstName, String lastName, String email, String confirmEmail, String password, String confirmPassword) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        emailInput.setValue(email);
        emailInputConfirm.setValue(confirmEmail);
        passwordInput.setValue(password);
        passwordInputConfirm.setValue(confirmPassword);
    }

    public void submitForm() {
        submitBtn.click();
    }

    public void verifySuccessMessage() {
        $(".success-message").shouldHave(text("You're all set! Go ahead and login!"));
    }
}