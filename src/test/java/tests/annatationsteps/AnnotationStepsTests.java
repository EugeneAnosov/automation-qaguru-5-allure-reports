package tests.annatationsteps;

import base.TestBase;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotationStepsTests extends TestBase {

    @Test
    @Owner("eugeneanosov")
    @DisplayName("Annotation Steps Test")
    @Feature("Working with marking")
    @Story("Marking of annotations")
    @Severity(SeverityLevel.NORMAL)
    public void testIssueSearch() {

        GithubPages githubPages = new GithubPages();

        SelenideLogger.addListener("allure", new AllureSelenide());

        githubPages.openMainPage();
        githubPages.searchRepository();
        githubPages.clickByRepositoryLink();
        githubPages.openIssuesTab();
    }
}
