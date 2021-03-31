package tests.annatationsteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static base.TestData.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubPages {

    @Step("Open github page")
    public void openMainPage() {
        open(baseUrl);
    }

    @Step("Search repository by name")
    public void searchRepository() {
        $("[name=q]").setValue(REPOSITORY).pressEnter();
        $("#js-pjax-container").shouldHave(text(REPOSITORY));
    }

    @Step("Click by repository name")
    public void clickByRepositoryLink() {
        $(byLinkText(REPOSITORY)).click();
        $("#repo-content-pjax-container").shouldHave(text(DESCRIPTION_TEXT));
    }

    @Step("Open Issue tab")
    public void openIssuesTab() {
        $("[data-content=Issues]").click();
        $("#issue_1443_link").shouldHave(Condition.text(ISSUE_NAME));
    }
}
