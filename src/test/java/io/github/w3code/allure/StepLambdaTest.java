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
    private static final Integer ISSUE_NUMBER = 1628;

    @Test
    @Owner("w3code")
    @DisplayName("Поиск Issue")
    @Link(name = "GitHub", url="https://github.com")
    public void testGithub() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();

        });
        step("Открываем таб Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем, что Issue #"+ ISSUE_NUMBER + " существует", () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });
    }

}
