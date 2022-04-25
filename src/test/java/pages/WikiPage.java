package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class WikiPage {

    SelenideElement soft = $(By.linkText("Soft assertions"));

    public SoftAssertionsPage getSoftAssertions() {
        soft.click();
        return new SoftAssertionsPage();
    }

}
