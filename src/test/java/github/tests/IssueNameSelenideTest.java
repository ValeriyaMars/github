package github.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueNameSelenideTest {

    @Test
    public void checkIssueName() {
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("eroshenkoam/allure-example").pressEnter();
        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $("#issue_80").shouldHave(text("e.sh"));
    }
}
