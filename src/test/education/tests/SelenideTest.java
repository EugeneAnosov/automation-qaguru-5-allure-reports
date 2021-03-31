package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String ISSUE_NAME = "Listeners NamedBy";
    private final static String BASE_URL = "https://github.com/";

    @Test
    @DisplayName("Selenide's logger")
    public void testIssueSearch() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open(BASE_URL);
        $("[name=q]").setValue(REPOSITORY).pressEnter();
        $(byLinkText("eroshenkoam/allure-example")).click();
        $("[data-content=Issues]").click();
        $(byLinkText(ISSUE_NAME)).should(Condition.exist);
    }
}
