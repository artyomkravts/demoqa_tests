package demoqa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertAll;

@Tag("remote")
public class TextBoxTest extends BaseTest {

    private String name;
    private String email;
    private String addressCurrent;
    private String addressPermanent;

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
