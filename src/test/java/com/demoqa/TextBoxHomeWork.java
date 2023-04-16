package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxHomeWork extends HomeWorkBase {
    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Виктор");
        $("#lastName").setValue("Рыбаков");
        $("#userEmail").setValue("7152955@gmail.com");
        $("#gender-radio-1").parent().click();
        //пошли на уровень выше
        $("#userNumber").setValue("7906072649");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1989");
        $("[aria-label=\"Choose Monday, April 10th, 1989\"]").click();
        //поиск по классу
        $("#subjectsInput").scrollTo().setValue("Math").pressEnter();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFromClasspath("image.jpg");
        $("#currentAddress").setValue("Винокурова");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        //отправить
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Виктор"),
                text("Рыбаков"),
                text("7152955@gmail.com"),
                text("Male"),
                text("7906072649"),
                text("10 April,1989"),
                text("Math"),
                text("Reading"),
                text("image.jpg"),
                text("Винокурова"),
                text("NCR"),
                text("Delhi"));
    }
}
