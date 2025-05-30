package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;

public class RegistrationWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void successfulRegistrationTest() {
        Faker faker = new Faker(new Locale("it"));


//        String firstName = faker.name().firstName(); // Emory
//        String lastName = faker.name().lastName(); // Barton


//        // Подход №1 хранение тестовых данных в переменных
        String userName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();

//        String phoneNumberFake = faker.phoneNumber().phoneNumber();
//        String phoneNumber = "1234567890";
        String phoneNumber = "8" + faker.number().digits(9);

        String currentAddress = faker.address().fullAddress();

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Other")
                .setPhone(phoneNumber)
                .setAddress(currentAddress)
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
        registrationPage.verifyResult("Student Name", userName + " " + lastName);
        registrationPage.verifyResult("Student Email", userEmail);
        registrationPage.verifyResult("Gender", "Other");
        registrationPage.verifyResult("Mobile", phoneNumber);
        registrationPage.verifyResult("Date of Birth", "30 July,1994");
        registrationPage.verifyResult("Address", currentAddress);
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
