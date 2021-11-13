package io.github.w3code.allure;

import io.github.w3code.allure.steps.WebSteps;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest {

    private static final String REPOSITORY = "nextcloud/docker";
    private static final String ISSUE_TITLE = "no app in context in logs";

    private WebSteps steps = new WebSteps();

    @Test
    @Owner("w3code")
    @DisplayName("Find issue by title")
    @Link(name = "GitHub", url="https://github.com")
    public void testGithub() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithTitle(ISSUE_TITLE);
    }

}
