package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        String userName = "Alex";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Egorov")
                .setEmail("alex@mail.ru")
                .setGender("Other")
                .setPhone("9777237756")
                .setAddress("Another address 2")
                .setBirthDate("30", "July", "1994");

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

//        registrationPage.registrationResultsModal.verifyResult ("Student Name", userName + "Egorov"); // Если в RegistrationPage  сделать     RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal() публичным то можно напрямую обратиться  (Плохая практика);

        registrationPage.verifyResultsModalAppears();
        registrationPage.verifyResult("Student Name", userName + " Egorov");
        registrationPage.verifyResult("Student Email", "alex@mail.ru");
        registrationPage.verifyResult("Gender", "Other");
        registrationPage.verifyResult("Mobile", "9777237756");
        registrationPage.verifyResult("Date of Birth", "30 July,1994");
    }


//    @Test
//    void successfulRegistration1Test() {
//        String userName = "Alex";
//
//        registrationPage.openPage();
//        registrationPage.setFirstName(userName);
//        registrationPage.setLastName("Egorov");
//        registrationPage.setEmail("alex@mail.ru");
//        registrationPage.setGender("Other");
//        registrationPage.setPhone("9777237756");
//        registrationPage.setAddress("Another address 2");
//
//
//        //Radiobutton
//      $("#gender-radio-1").parent().click();//good
//        $("#genterWrapper").$(byText("Other")).click();// best
//
//        //Calendar
//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOption("July");  // or selectOptionByValue
//        $(".react-datepicker__year-select").selectOptionByValue("1994");
//        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//
//        //Input with autocomplete
//        $("#subjectsInput").setValue("Math").pressEnter();
//
//        //Checkbox
//        $("#hobbiesWrapper").$(byText("Music")).click();
//
//        //Change file
//        $("#uploadPicture").uploadFromClasspath("img/1.png"); //best работает только с элементом с type = file;
//
//        //Select
//        $("#state").click();
//        $("#stateCity-wrapper").$(byText("NCR")).click();
//
//        $("#city").click();
//        $("#stateCity-wrapper").$(byText("Delhi")).click();
//
//        //Button
//        $("#submit").click();
//
//        $(".modal-dialog").should(appear);
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive").shouldHave(text(userName), text("Egorov"), text("alex@mail.ru"), text("9777237756"));
//    }


}
