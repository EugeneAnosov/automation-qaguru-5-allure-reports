package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps  {

    @Step("Open github page")
    public void openGithubPage() {
        open("https://github.com/");
    }

    @Step("Search {repository} repository")
    public void searchRepository(String repository) {
        $("[name=q]").setValue(repository).pressEnter();
    }

    @Step("Go to {repository} repository")
    public void goToRepository(String repository) {
        $(byLinkText(repository)).click();
    }

    @Step("Switch to Issues tab")
    public void switchToIssueTab() {
        $("[data-content=Issues]").click();
    }

    @Step("Check existing {issueName} issue")
    public void checkIssueByName(String issueName) {
        $(byLinkText(issueName)).should(Condition.exist);
    }
}
