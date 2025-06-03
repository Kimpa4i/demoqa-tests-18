package demoqa.pages.components;

import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {


    public void verifyModalAppears() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }

    public void verifyResult(String key, String value) {
        //        $(".table-responsive").shouldHave(text(userName), text("Egorov"), text("alex@mail.ru"), text("9777237756"));
        $(".table-responsive").$(Selectors.byText(key)).parent().shouldHave(text(value));

    }


}
