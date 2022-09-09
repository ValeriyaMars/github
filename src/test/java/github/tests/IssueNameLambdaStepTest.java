package github.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueNameLambdaStepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NAME = "e.sh";

    @Test
    public void checkIssueName() {
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("[data-test-selector=nav-search-input]").setValue(REPOSITORY).pressEnter();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Переходим в раздел Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем Issue с названием " + ISSUE_NAME, () -> {
            $("#issue_80").shouldHave(text(ISSUE_NAME));
        });


    }
}
