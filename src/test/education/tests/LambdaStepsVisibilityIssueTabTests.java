package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsVisibilityIssueTabTests {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String ISSUE_NAME = "Listeners NamedBy";
    private final static String BASE_URL = "https://github.com/";

    @Test
    public void checkLambdaIssueTabVisibilityTest(){

        Allure.parameter("repository", REPOSITORY);
        Allure.parameter("Issue Name", ISSUE_NAME);

        step( "Open github page", (step) -> {
            step.parameter("url", BASE_URL);
            open(BASE_URL);
        });
        step( "Search eroshenkoam/allure-example repository", (step) -> {
            step.parameter("repository", REPOSITORY);
            $("[name=q]").setValue(REPOSITORY).pressEnter();
        });
        step( "Go to eroshenkoam/allure-example repository", (step) -> {
            step.parameter("repository", REPOSITORY);
            $(byLinkText("eroshenkoam/allure-example")).click();
        });
        step( "Switch to Issues tab", (step) -> {
            $("[data-content=Issues]").click();
        });
        step( "Check existing 'Listeners NamedBy'", (step) -> {
            step.parameter("Listeners NamedBy", ISSUE_NAME);
            $(byLinkText(ISSUE_NAME)).should(Condition.exist);
        });
    }
}
