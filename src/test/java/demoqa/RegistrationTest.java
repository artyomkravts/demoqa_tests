package demoqa;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;
import java.util.Locale;

import static io.qameta.allure.Allure.step;

public class RegistrationTest extends BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        Faker faker = new Faker(new Locale("EN"));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String addressCurrent = faker.address().streetAddress();
        String mobile = faker.numerify("7#########");

        step("Fill in the form", () -> {
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
        });

        step("Verify fields in the form", () -> {
            registrationPage.verifyModalAppears()
                    .verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", email)
                    .verifyResult("Gender", "Male")
                    .verifyResult("Mobile", mobile)
                    .verifyResult("Address", addressCurrent)
                    .verifyResult("State and City", "Rajasthan Jaipur");
        });
    }
}
