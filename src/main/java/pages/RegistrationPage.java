package pages;

import enums.Month;
import enums.States;
import enums.Subjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage {
    private WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public static final String URL = "https://demoqa.com/automation-practice-form";

    @FindBy(xpath = "//label[contains(@for, 'gender-radio')]")
    List<WebElement> genderElements;
    @FindBy(id = "firstName")
    WebElement firstNameElement;
    @FindBy(css = "input[id='lastName']")
    WebElement lastNameElement;
    @FindBy(id = "userEmail")
    WebElement emailElement;
    @FindBy(id = "userNumber")
    WebElement userNumberElement;
    @FindBy(id = "subjectsInput")
    WebElement subjectsElement;
    @FindBy(id = "currentAddress")
    WebElement currentAddressElement;
    @FindBy(id = "dateOfBirthInput")
    WebElement dateElement;
    @FindBy(id = "state")
    WebElement stateElement;
    @FindBy(id = "city")
    WebElement cityElement;
    @FindBy(id = "uploadPicture")
    WebElement uploadPictureElement;
    @FindBy(id="submit")
    WebElement submitElement;

    public WebElement getUploadPictureElement() {
        return uploadPictureElement;
    }

    public WebElement getFirstNameElement() {
        return firstNameElement;
    }

    public WebElement getLastNameElement() {
        return lastNameElement;
    }

    public WebElement getEmailElement() {
        return emailElement;
    }

    public WebElement getUserNumberElement() {
        return userNumberElement;
    }

    public WebElement getCurrentAddressElement() {
        return currentAddressElement;
    }


    public RegistrationPage selectDate(int year, Month month, int day) {
        dateElement.click();
        Select selectYear = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        selectYear.selectByValue(String.valueOf(year));
        Select selectMonth = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        selectMonth.selectByValue(String.valueOf(month.ordinal()));
        driver.findElement(
                        By.xpath("//div[@class = 'react-datepicker__month']//div[contains(@aria-label, '"
                                + month.getDisplayName() + " " + day + "')]"))
                .click();
        return this;
    }

    public RegistrationPage selectStateCity(States state, String city) {
        new Actions(driver).scrollToElement(stateElement).scrollByAmount(0,50).perform();
        stateElement.click();
        driver.findElement(By.xpath("//div[@id = 'state']//div[text()='" + state.getName() + "']")).click();
        cityElement.click();
        driver.findElement(By.xpath("//div[@id = 'city']//div[text()='" + city + "']")).click();
        return this;
    }

    public RegistrationPage genderChoice(int a) {
        genderElements.get(a).click();
        return this;
    }

    public String getValueByField(String field) {
        return driver.findElement(By.xpath("//td[contains(text(), '" + field + "')]/../td[2]")).getText();
    }

    public RegistrationPage inputSubject(Subjects subject) {
        new Actions(driver).scrollToElement(subjectsElement).scrollByAmount(0, 50).perform();
        subjectsElement.click();
        subjectsElement.sendKeys(subject.getName());
        subjectsElement.sendKeys(Keys.ENTER);
        return this;
    }

    public String getValueTitle() {
        return driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
    }

    public RegistrationPage submitData(){
        submitElement.click();
        return this;
    }

}
