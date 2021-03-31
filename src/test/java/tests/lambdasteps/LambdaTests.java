package tests.lambdasteps;

import base.TestBase;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LambdaTests extends TestBase {

    @Test
    @Owner("eugeneanosov")
    @DisplayName("Lambda Steps Test")
    @Feature("Working with marking")
    @Story("Marking of annotations")
    @Severity(SeverityLevel.TRIVIAL)
    public void testIssueSearch() {

        GithubPages githubPages = new GithubPages();

        SelenideLogger.addListener("allure", new AllureSelenide());

        githubPages.openMainPage();
        githubPages.searchRepository();
        githubPages.clickByRepositoryLink();
        githubPages.openIssuesTab();
    }
}
