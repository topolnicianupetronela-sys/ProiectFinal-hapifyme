package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class ProfilePage {

    private SelenideElement searchField = $("#search, #search_text_input");
    private SelenideElement searchBtn = $(By.className("button_holder"));
    public SelenideElement listResults = $("#main_column");

    private final String PROFILE_URL = "https://test.hapifyme.com/profile.php";

    public void openPage() {
        open(PROFILE_URL);
    }

    public void openPage(String url) {
        open(url);
    }

    public void searchUser(String q) {
        searchField.setValue(q);
        searchBtn.click();
    }

    public void openFirstResult() {
        listResults.shouldBe(visible);
    }

}