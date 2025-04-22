package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertAll;

public class TextBoxTest {

    private String name;
    private String email;
    private String addressCurrent;
    private String addressPermanent;

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        name = "Egorka";
        email = "egorka@gmail.com";
        addressCurrent = "San Francisco, CA";
        addressPermanent = "CA";

        open("/text-box");

        $(".text-center").shouldHave(text("Text Box"));

        $("#userName").setValue(name);
        $("[id=userEmail]").setValue(email);
        $("#currentAddress").setValue(addressCurrent);
        $("#permanentAddress").setValue(addressPermanent);
        $("#submit").click();

        assertAll(() -> {
            $("#output").shouldBe(visible);
            $("#output #name").shouldHave(text(name));
            $("#output #email").shouldHave(text(email));
            $("#output #currentAddress").shouldHave(text(addressCurrent));
            $("#output #permanentAddress").shouldHave(text(addressPermanent));
        });





    }
}
