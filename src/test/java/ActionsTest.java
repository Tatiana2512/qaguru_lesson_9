import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ActionsTest {

    SelenideElement a = $("#column-a");
    SelenideElement b = $("#column-b");

    @BeforeAll
    static void setUp(){
        Configuration.browserSize = "1400x800";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    void dragnDrop1stTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        Selenide.actions()
                .moveToElement(a)
                .clickAndHold()
                .moveToElement(b)
                .release()
                .build()
                .perform();

        a.$("header").shouldHave(Condition.text("B"));


    }

    @Test
    void dragnDrop2ndTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        a.dragAndDropTo(b);
        a.$("header").shouldHave(Condition.text("B"));

    }


}

