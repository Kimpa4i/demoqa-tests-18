package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTestsWithComments {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulRegistrationTest() {
        String userName = "Alex";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        //JavaScript remove banner and footer
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(userName);
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("alex@mail.ru");
        $("#userNumber").setValue("9777237756");
        $("#currentAddress").setValue("Another address 2");

        //Radiobutton
//        $("#gender-radio-1").click(); //wrong
        $("#gender-radio-1").parent().click();//good
//        $(byText("Other")).click();// not very good local lenguage
//        $("label[for = gender-radio-1]").click();// good
        $("#genterWrapper").$(byText("Other")).click();// best

        //Calendar
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");  // or selectOptionByValue
//        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOptionByValue("1994");
        // <div class="react-datepicker__day--030 react-datepicker__day--outside-month">30</div>
        // <div class="react-datepicker__day--030">30</div>
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $x( "//*[@class=' react-datepicker__day--030'] [not (contains(@class, 'react-datepicker__day-outside-month'))]").click(); //xpath

        //Input with autocomplete
        $("#subjectsInput").setValue("Math").pressEnter();

        //Checkbox
        $("#hobbiesWrapper").$(byText("Music")).click();

        //Change file
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));//good
        $("#uploadPicture").uploadFromClasspath("img/1.png"); //best работает только с элементом с type = file;

        //Select
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#react-select-3-option-0").click(); Клик прямо по id

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        //Button
        $("#submit").click();


        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Egorov"), text("alex@mail.ru"), text("9777237756"));


        sleep(5000);
    }


}
