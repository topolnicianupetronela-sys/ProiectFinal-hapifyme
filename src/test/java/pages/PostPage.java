package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.SelenideElement;

public class PostPage {

    private final SelenideElement postTextArea =  $("textarea[name='post_text']");
    private final SelenideElement postButton =  $("#post_button");
    private final SelenideElement PostText =  $(".post_body_content");

    public void openPage() {
        open("https://test.hapifyme.com/index.php");
        $(".main_column").shouldBe(visible); // verificăm că suntem pe feed
    }

    public void createPost(String message) {
        $(postTextArea).setValue(message);
        $(postButton).click();
    }

    public void verifyPostText(String expectedText) {

        $(PostText).shouldHave(text(expectedText));
    }
}