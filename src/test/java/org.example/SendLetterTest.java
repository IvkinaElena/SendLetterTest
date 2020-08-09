package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SendLetterTest {
    public MailPage mailPage;
    public PassportPage passportPage;
    public WebDriver driver;

    @BeforeAll
    public void setup(){
        System.setProperty("webdriver.chrome.driver", Parameters.chromedriver);
        driver = new ChromeDriver();
        mailPage = new MailPage(driver);
        passportPage = new PassportPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Parameters.startUrl);
        mailPage.clickEnterBtn();

        passportPage.inputLogin(Parameters.login)
                    .clickLoginBtn()
                    .inputPassword(Parameters.password)
                    .clickLoginBtn()
                    .clickNotNowBtn();
    }

    @Test
    public void testSendLetter(){
        //тема письма задается текущим временем
        Date date = new Date();
        String subject = date.toString();

        mailPage.clickWriteBtn()
                .inputAddressee(Parameters.addressee)
                .inputSubject(subject)
                .inputContent(Parameters.contentOfLetter)
                .clickSendBtn()
                .refresh();

        assertTrue(mailPage.getSubjects().contains(subject));
    }

    @AfterAll
    public void tearDown() {
        mailPage.entryMenu()
                .userLogout();
        driver.quit(); }
}
