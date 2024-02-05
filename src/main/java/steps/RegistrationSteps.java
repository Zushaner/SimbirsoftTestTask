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

    @Step("Введено имя = {text}")
    public RegistrationSteps inputFirstName(String text) {
        registrationPage.getFirstNameElement().sendKeys(text);
        return this;
    }
    @Step("Введена фамилия = {text}")
    public RegistrationSteps inputLastName(String text) {
        registrationPage.getLastNameElement().sendKeys(text);
        return this;
    }
    @Step("Введен email = {text}")
    public RegistrationSteps inputEmail(String text) {
        registrationPage.getEmailElement().sendKeys(text);
        return this;
    }
    @Step("Введен мобильный номер = {number}")
    public RegistrationSteps inputMobile(String number) {
        registrationPage.getUserNumberElement().sendKeys(number);
        return this;
    }
    @Step("Выбран пол")
    public RegistrationSteps selectGender(int a) {
        registrationPage.selectGender(a);
        return this;
    }
    @Step("Выбрана дата = {day} {month.displayName} {year}")
    public RegistrationSteps selectDate(int year, Month month, int day) {
        registrationPage.selectDate(year, month, day);
        return this;
    }
    @Step("Введен предмет = {subject.name}")
    public RegistrationSteps inputSubject(Subjects subject) {
        registrationPage.inputSubject(subject);
        return this;
    }
    @Step("Введен адрес = {address}")
    public RegistrationSteps inputAddress(String address) {
        registrationPage.getCurrentAddressElement().sendKeys(address);
        return this;
    }
    @Step("Введены штат и город = {state.name} {city}")
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
