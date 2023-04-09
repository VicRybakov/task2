package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTest extends TestBase {
    @Test
    void successfulFillFormTest() {
        open("/text-box");
        $("#userName").setValue("Mr.Smith");
        $("#userEmail").setValue("7152955@gmail.com");
        $("#currentAddress").setValue("Street");
        $("#permanentAddress").setValue("Street");
        $("#submit").click();
        $("#output").shouldHave(text("Mr.Smith"), text("7152955@gmail.com"),
                text("Street"), text("Street"));
    }
}
