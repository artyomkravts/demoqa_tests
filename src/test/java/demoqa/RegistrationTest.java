package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

public class RegistrationTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @Test
    void fillFormTest() {
        String firstName = "Egorka";
        String lastName = "Smirnov";
        String email = "egorka@gmail.com";
        String addressCurrent = "San Francisco, CA";
        String mobile = "7123456789";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmailInput(email)
                .clickGenderRadioButtonByNumber(registrationPage.GENDER_MALE)
                .setUserNumberInput(mobile)
                .setDayMonthYear(registrationPage.DAY20, registrationPage.APRIL, registrationPage.YEAR2000)
                .setSubject(registrationPage.SUBJECT_COMPUTER_SCIENCE)
                .setSubject(registrationPage.SUBJECT_MATHS)
                .clickHobbiesCheckboxByNumber(registrationPage.HOBBY_SPORTS)
                .uploadImage(new File("src/test/resources/img.png"))
                .setCurrentAddressInput(addressCurrent)
                .setStateByNumber(registrationPage.STATE_RAJASHTAN)
                .setCityByNumber(registrationPage.CITY_JAIPUR)
                .clickSubmitButton();

        registrationPage.verifyModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", mobile)
                .verifyResult("Address", addressCurrent)
                .verifyResult("State and City", "Rajasthan Jaipur");
    }
}
