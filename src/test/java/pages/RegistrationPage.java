package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponents calendarComponent = new CalendarComponents();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    // Final
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderRadio = $("#genterWrapper");
    private SelenideElement userPhoneInput = $("#userNumber");
    private SelenideElement userAddresInput = $("#currentAddress");
    private SelenideElement dateOfBirthdayInput = $("#dateOfBirthInput");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        //JavaScript remove banner and footer
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        return this;
    }

    //Можно переиспользовать
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

//    //Зашит под определенный тест
//    public void setLastName() {
//        $("#lastName").setValue("Egorov"); bad
//    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage clearLastName() {
        lastNameInput.clear();
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        //        $("#gender-radio-1").parent().click();//good
        genderRadio.$(byText(value)).click();//best
        return this;
    }

    public RegistrationPage setPhone(String value) {
        userPhoneInput.setValue(value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        userAddresInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        //кнопка может быть разной для разных случаев, поэтому в методе
        dateOfBirthdayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }


}


