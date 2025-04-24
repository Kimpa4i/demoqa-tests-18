package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponents {


    public void setDate(String day, String month, String year) {
        //Calendar
        $(".react-datepicker__month-select").selectOption(month);  // or selectOptionByValue
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

    }

}
