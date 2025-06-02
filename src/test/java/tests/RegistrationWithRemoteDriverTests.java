package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegistrationWithRemoteDriverTests extends TestBaseExtended {

    @Test
    @Tag("remote")
    void successfulRegistrationTest() {


        step("Open form", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            //JavaScript remove banner and footer
            Selenide.executeJavaScript("$('#fixedban').remove()");
            Selenide.executeJavaScript("$('footer').remove()");
        });


        step("Fill form", () -> {

            $("#firstName").setValue("Alex");
            $("#lastName").setValue("Egorov");
            $("#userEmail").setValue("alex@mail.ru");
            $("#userNumber").setValue("9777237756");
            $("#currentAddress").setValue("Another address 2");

            //Radiobutton
            $("#gender-radio-1").parent().click();//good
            $("#genterWrapper").$(byText("Other")).click();// best

            //Calendar
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");  // or selectOptionByValue
            $(".react-datepicker__year-select").selectOptionByValue("1994");
            $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

            //Input with autocomplete
            $("#subjectsInput").setValue("Math").pressEnter();

            //Checkbox
            $("#hobbiesWrapper").$(byText("Music")).click();

            //Change file
            $("#uploadPicture").uploadFromClasspath("img/1.png"); //best работает только с элементом с type = file;

            //Select
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();

            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();

            //Button
            $("#submit").click();
        });

        step("Verify results", () -> {
            $(".modal-dialog").should(appear);
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text("Alex"), text("Egorov"), text("alex@mail.ru"), text("9777237756"));
        });

    }


}