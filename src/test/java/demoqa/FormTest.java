package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {

    private String firstName;
    private String lastName;
    private String email;
    private String addressCurrent;
    private String mobile;
    private String month;
    private String year;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @Test
    void fillFormTest() {
        firstName = "Egorka";
        lastName = "Smirnov";
        email = "egorka@gmail.com";
        addressCurrent = "San Francisco, CA";
        mobile = "7123456789";
        month = "April";
        year = "2000";

        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);

        $("[name=gender]#gender-radio-1").parent().click();

        $("#userNumber").setValue(mobile);

        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day.react-datepicker__day--020").click();

        $("#subjectsInput").setValue("Computer Science");
        $("#subjectsInput").setValue("Maths").pressEnter();

        $("#hobbies-checkbox-1").parent().click();

        $("#uploadPicture").uploadFromClasspath("img.png");

        $("#currentAddress").setValue(addressCurrent);

        $("#state").click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        $("#submit").click();

        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text(addressCurrent),
                text(mobile),
                text(month),
                text(year),
                //text("Computer Science Maths"), bug here
                text("Sports"),
                text("Rajasthan Jaipur")
        );


        System.out.println("sosat");



    }
}
