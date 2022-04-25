package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RepoListPage {

    public RepoSelenidePage getExactRepo(String repo) {
        $(By.linkText(repo)).click();
        return new RepoSelenidePage();
    }

    public ElementsCollection getRepoList() {
        return $$(".v-align-middle");
    }

}
