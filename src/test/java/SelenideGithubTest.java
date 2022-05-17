import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import static io.qameta.allure.Allure.step;

@Tag("ui")
public class SelenideGithubTest {

    @BeforeAll
    static void setUp() {

        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1400x800";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }


    StartPage start = new StartPage();
    RepoListPage list = new RepoListPage();
    RepoSelenidePage selenide = new RepoSelenidePage();
    WikiPage wiki = new WikiPage();
    SoftAssertionsPage soft = new SoftAssertionsPage();

    @Test
    public void selenideTestJUnit() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open Github main page", () -> {
            start.openPage();
        });

        step("Search for repo by text", () -> {
            start.openRepoList("selenide/selenide");
        });

        step("Click on repo link", () -> {
            list.getExactRepo("selenide/selenide");
        });
        step("Open wiki tab", () -> {
            selenide.getWiki();
        });
        step("Click Soft assertions link", () -> {
            wiki.getSoftAssertions();
        });
        step("Check if page has JUnit5 result", () -> {
            soft.seachJUnit5Code();
        });

    }

}