package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsPage {

    public SelenideElement header = $$("h4").last();

    public void seachJUnit5Code() {
        header.shouldBe(visible).shouldHave(text("JUnit5"));
        $x("//div[contains(@class,'source-java')]//pre//span[text()='ExtendWith']").should(Condition.exist);


    }

}


