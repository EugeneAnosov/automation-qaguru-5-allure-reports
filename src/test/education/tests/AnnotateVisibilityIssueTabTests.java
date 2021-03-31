package tests;

import org.junit.jupiter.api.Test;

public class AnnotateVisibilityIssueTabTests {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String ISSUE_NAME = "Listeners NamedBy";

    private WebSteps steps = new WebSteps();

    @Test
    void checkAnnotateIssueTabVisibilityTest(){
        steps.openGithubPage();
        steps.searchRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.switchToIssueTab();
        steps.checkIssueByName(ISSUE_NAME);
    }
}
