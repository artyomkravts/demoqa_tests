package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final String TITLE_TEXT = "Student Registration Form";

    public final String
            APRIL = "April",
            DAY20 = "20",
            YEAR2000 = "2000",
            GENDER_MALE = "1",
            HOBBY_SPORTS = "1",
            SUBJECT_COMPUTER_SCIENCE = "Computer Science",
            SUBJECT_MATHS = "Maths",
            STATE_RAJASHTAN = "3",
            CITY_JAIPUR = "0";

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmailInput(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage setUserNumberInput(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setCurrentAddressInput(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage setDayMonthYear(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setStateByNumber(String number) {
        $("#state").click();
        $(String.format("#react-select-3-option-%s", number)).click();
        return this;
    }

    public RegistrationPage setCityByNumber(String number) {
        $("#city").click();
        $(String.format("#react-select-4-option-%s", number)).click();
        return this;
    }

    public RegistrationPage clickHobbiesCheckboxByNumber(String number) {
        $(String.format("#hobbies-checkbox-%s", number)).parent().click();
        return this;
    }

    public RegistrationPage clickGenderRadioButtonByNumber(String number) {
        $(String.format("[name=gender]#gender-radio-%s", number)).parent().click();
        return this;
    }

    public RegistrationPage uploadImage(File image) {
        uploadPictureInput.uploadFile(image);
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}
