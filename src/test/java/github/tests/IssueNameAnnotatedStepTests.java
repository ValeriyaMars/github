package github.tests;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("Marshenina")
public class IssueNameAnnotatedStepTests {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NAME = "e.sh";
    private WebSteps steps = new WebSteps();

    @Test
    @Link(name = "Главная страница", url = "https://github.com")
    @DisplayName("Проверка названия Issue")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSeeIssueNameInRepository() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueName(ISSUE_NAME);
    }
}
