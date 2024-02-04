package steps;

import enums.Month;
import enums.States;
import enums.Subjects;
import io.qameta.allure.Step;
import pages.RegistrationPage;

import java.io.File;


public class RegistrationSteps {
    private final RegistrationPage registrationPage;

    public RegistrationSteps(RegistrationPage page) {
        registrationPage = page;
    }

    @Step("Введено первое имя = {text}")
    public RegistrationSteps inputFirstName(String text) {
        registrationPage.getFirstNameElement().sendKeys(text);
        return this;
    }

    @Step("Введено второе имя")
    public RegistrationSteps inputSecondName(String text) {
        registrationPage.getLastNameElement().sendKeys(text);
        return this;
    }

    @Step("Введен email")
    public RegistrationSteps inputEmail(String text) {
        registrationPage.getEmailElement().sendKeys(text);
        return this;
    }
    @Step("Введен мобильный номер")
    public RegistrationSteps inputMobile(String number) {
        registrationPage.getUserNumberElement().sendKeys(number);
        return this;
    }
    @Step("Выбран пол")
    public RegistrationSteps choiceGender(int a) {
        registrationPage.genderChoice(a);
        return this;
    }
    @Step("Выбрана дата")
    public RegistrationSteps selectDate(int year, Month month, int day) {
        registrationPage.selectDate(year, month, day);
        return this;
    }
    @Step("Введен предмет")
    public RegistrationSteps inputSubject(Subjects subject) {
        registrationPage.inputSubject(subject);
        return this;
    }
    @Step("Введен адрес")
    public RegistrationSteps inputAddress(String address) {
        registrationPage.getCurrentAddressElement().sendKeys(address);
        return this;
    }
    @Step("Введены штат и город")
    public RegistrationSteps selectStateAndCity(States state, String city) {
        registrationPage.selectStateCity(state,city);
        return this;
    }
    @Step("Добавлено изображение")
    public RegistrationSteps attachPicture(File image) {
        String ap = image.getAbsolutePath();
        registrationPage.getUploadPictureElement().sendKeys(ap);
        return this;
    }

    @Step("Данные отправлены")
    public  RegistrationSteps submitData() {
        registrationPage.submitData();
        return this;

    }
}