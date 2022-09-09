package github.tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий [{repository}]")
    public void searchForRepository(String repository) {
        $("[data-test-selector=nav-search-input]").setValue(repository).pressEnter();
    }

    @Step("Переходим в репозиторий [{repository}]")
    public void goToRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Переходим в раздел Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем Issue с названием [{name}]")
    public void shouldSeeIssueName(String name) {
        $("#issue_80").shouldHave(text(name));
    }
}
