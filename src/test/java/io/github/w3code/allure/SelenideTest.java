package io.github.w3code.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Test
    @Owner("w3code")
    @DisplayName("Поиск Issue")
    @Link(name = "GitHub", url = "https://github.com")
    public void testGithub() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("nextcloud/docker");
        $(".header-search-input").submit();

        $(linkText("nextcloud/docker")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#1628")).should(Condition.visible);
    }

}
