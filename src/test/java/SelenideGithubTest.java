import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.*;

public class SelenideGithubTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://github.com";
    }


    StartPage start = new StartPage();
    RepoListPage list = new RepoListPage();
    RepoSelenidePage selenide = new RepoSelenidePage();
    WikiPage wiki = new WikiPage();
    SoftAssertionsPage soft = new SoftAssertionsPage();

    @Test
    public void selenideTestJUnit() {

        start.openPage();
        start.openRepoList("selenide/selenide");
        list.getExactRepo("selenide/selenide");
        selenide.getWiki();
        wiki.getSoftAssertions();
        soft.seachJUnit5Code();

    }

}