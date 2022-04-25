import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class ActionsTest {

    SelenideElement a = $("#column-a");
    SelenideElement b = $("#column-b");

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

