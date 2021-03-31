package tests.selenidelogger;

import com.codeborne.selenide.Condition;

import static base.TestData.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubPages {

    public void openMainPage() {
        open(baseUrl);
    }

    public void searchRepository() {
        $("[name=q]").setValue(REPOSITORY).pressEnter();
        $("#js-pjax-container").shouldHave(text(REPOSITORY));
    }

    public void clickByRepositoryLink() {
        $(byLinkText(REPOSITORY)).click();
        $("#repo-content-pjax-container").shouldHave(text(DESCRIPTION_TEXT));
    }

    public void openIssuesTab() {
        $("[data-content=Issues]").click();
        $("#issue_1443_link").shouldHave(Condition.text(ISSUE_NAME));
    }
}
