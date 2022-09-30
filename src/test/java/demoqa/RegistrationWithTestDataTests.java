package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

public class RegistrationWithTestDataTests extends TestBase {

    String firstName = "Vlad";
    String lastName = "Bold";
    String email = "test@mail.com";
    String fullName = format("%s %s", firstName, lastName);

    @Test
    @Tag("demoqa")
    @DisplayName("Successful registration test")
    void regFormTest() {
        String currentAddress = "Moscow";
        String phone = "79000000000";

        step("Open registration form", () -> {
                    open("/automation-practice-form");
        });

        step("Fill registration form", () -> {
            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(email);


//        $("#gender-radio-3 + label").click();
//        $("#genterWrapper").$(byText("Other")).click();
            executeJavaScript("arguments[0].click()", $("#gender-radio-3"));

            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("August");
            $(".react-datepicker__year-select").selectOption("2008");
            $(".react-datepicker__day--031:not(.react-datepicker__day--outside-month)").click();


            $("#subjectsInput").setValue("Maths").pressEnter();

//        $("#hobbies-checkbox-1 + label").click();
//        executeJavaScript("arguments[0].click()", $("#hobbies-checkbox-1"));
            $("#userNumber").setValue(phone);
            $("#uploadPicture").uploadFromClasspath("img/1.png");
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));

            $("#state").click();
            $("#stateCity-wrapper").$("#react-select-3-option-0").click();
            $("#city").click();
            $("#stateCity-wrapper").$("#react-select-4-option-0").click();
            $("#submit").click();
        });

        step("Verify form data", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text(fullName), text(email));
            $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text((fullName)));
        });
    }
}
