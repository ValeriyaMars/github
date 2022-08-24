package github.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void findJUnitExample(){
    open("https://github.com/");

    $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
    $(byText("Wikis")).click();
    $("#wiki_search_results").shouldHave(text("SoftAssertions"));
    $("[title=SoftAssertions]").click();
    $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();"));
        }
}
