package tests.lambdasteps;

import com.codeborne.selenide.Condition;

import static base.TestData.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GithubPages {

    public void openMainPage() {
        step( "Open github page", (step) -> {
        open(baseUrl);
        });
    }

    public void searchRepository() {
        step( "Search repository by name", (step) -> {
        $("[name=q]").setValue(REPOSITORY).pressEnter();
        $("#js-pjax-container").shouldHave(text(REPOSITORY));
        });
    }


    public void clickByRepositoryLink() {
        step( "Click by repository name", (step) -> {
        $(byLinkText(REPOSITORY)).click();
        $("#repo-content-pjax-container").shouldHave(text(DESCRIPTION_TEXT));
        });
    }

    public void openIssuesTab() {
        step("Open Issue tab", (step) -> {
        $("[data-content=Issues]").click();
        $("#issue_1443_link").shouldHave(Condition.text(ISSUE_NAME));
        });
    }
}
