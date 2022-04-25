package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RepoSelenidePage {

    SelenideElement WikiTab = $("#wiki-tab");

    public WikiPage getWiki() {
        WikiTab.click();
        return new WikiPage();
    }

}
