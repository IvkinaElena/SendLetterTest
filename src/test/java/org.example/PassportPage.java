package org.example;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassportPage {
    public WebDriver driver;
    public PassportPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    /**
     * определение локатора поля ввода логина
     */
    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginField;
    /**
     * определение локатора кнопки входа в аккаунт
     */
    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement loginBtn;
    /**
     * определение локатора поля ввода пароля
     */
    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwordField;
    /**
     * определение локатора кнопки "Не сейчас" в форме привязки телефона
     */
    @FindBy(xpath = "//div[contains(@data-t,'phone_skip')]")
    private WebElement notNowBtn;
    /**
     * метод для ввода логина
     */
    public PassportPage inputLogin(String login) {
        loginField.sendKeys(login);
        return this;
    }
    /**
     * метод для ввода пароля
     */
    public PassportPage inputPassword(String password) {

        passwordField.sendKeys(password);
        return this;
    }
    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    public PassportPage clickLoginBtn() {
        loginBtn.click();
        return this;
    }
    /**
     * метод для осуществления нажатия кнопки "Не сейчас"
     */
    public PassportPage clickNotNowBtn() {

        try {
            notNowBtn.click();
            return this;
        } catch (NoSuchElementException ex) {
             return this;
        }
    }

}


