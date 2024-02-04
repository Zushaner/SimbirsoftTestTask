package test;


import helpers.InitWebDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import models.DataDocument;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import steps.RegistrationSteps;

import java.io.File;

import static utils.StringUtils.dayToStringFormat;

public class RegistrationTests {
    private RegistrationSteps registrationSteps;
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @BeforeMethod
    public void before() {
        driver = InitWebDriver.initWebDriver();

        driver.get(RegistrationPage.URL);
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        registrationSteps = new RegistrationSteps(registrationPage);
    }

    @Test(testName = "")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void MainTest() {
        DataDocument document = DataDocument.generateRandomDocument();
        File image = new File("src/test/Images/Picture.PNG");

        registrationSteps
                .inputFirstName(document.firstName())
                .inputSecondName(document.secondName())
                .inputEmail(document.email())
                .choiceGender(document.gender())
                .inputMobile(document.number())
                .selectDate(document.year(), document.month(), document.day())
                .inputSubject(document.subjects())
                .attachPicture(image)
                .inputAddress(document.address())
                .selectStateAndCity(document.states(), document.city())
                .submitData();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(registrationPage.getValueTitle(), "Thanks for submitting the form");
        softAssert.assertEquals(registrationPage.getValueByField("Student Name"), (document.firstName() + " " + document.secondName()));
        softAssert.assertEquals(registrationPage.getValueByField("Student Email"), document.email());
        softAssert.assertEquals(registrationPage.getValueByField("Gender"), document.genderName());
        softAssert.assertEquals(registrationPage.getValueByField("Mobile"), document.number());
        softAssert.assertEquals(registrationPage.getValueByField("Date of Birth"),
                (dayToStringFormat(document.day()) + " " + document.month().getDisplayName() + "," + document.year()));
        softAssert.assertEquals(registrationPage.getValueByField("Subjects"), document.subjects().getName());
        softAssert.assertEquals(registrationPage.getValueByField("Picture"), image.getName());
        softAssert.assertEquals(registrationPage.getValueByField("Address"), document.address());
        softAssert.assertEquals(registrationPage.getValueByField("State and City"), (document.states().getName() + " " + document.city()));
        softAssert.assertAll();
    }

    @AfterMethod
    public void after() {
        driver.close();
    }
}
