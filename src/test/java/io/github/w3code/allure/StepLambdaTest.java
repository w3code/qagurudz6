package io.github.w3code.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaTest {

    private static final String REPOSITORY = "nextcloud/docker";
    private static final String ISSUE_TITLE = "no app in context in logs";

    @Test
    @Owner("w3code")
    @DisplayName("Find issue by title")
    @Link(name = "GitHub", url="https://github.com")
    public void testGithub() {
        step("Open main page", () -> {
            open("https://github.com");
        });
        step("Find repository '" + REPOSITORY + "'", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Open the '" + REPOSITORY + "' repository", () -> {
            $(linkText(REPOSITORY)).click();

        });
        step("Open the Issues tab", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Check Issue with '"+ ISSUE_TITLE + "' title is exists", () -> {
            $(withText(ISSUE_TITLE)).should(Condition.visible);
        });
    }

}
