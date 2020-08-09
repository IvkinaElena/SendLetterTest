package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MailPage {
    public WebDriver driver;
    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    /**
     * определение локатора поля входа на страницу авторизации
     */
    @FindBy(xpath = "//*[contains(@class, 'Button-Enter')]")
    private WebElement enterBtn;
    /**
     * определение локатора кнопки "Написать"
     */
    @FindBy(xpath = "//*[contains(@title, 'Написать')]")
    private WebElement writeBtn;
    /**
     * определение локатора поля адресата
     */
    @FindBy(xpath = "//*[contains(@class, 'MultipleAddressesDesktop-Field ComposeYabblesField')]/div[1]")
    private WebElement addresseeField;
    /**
     * определение локатора поля темы
     */
    @FindBy(xpath = "//input[contains(@class, 'composeTextField')]")
    private WebElement subjectField;
    /**
     * определение локатора поля содержания письма
     */
    @FindBy(xpath ="//div[contains(@placeholder, 'Напишите что-нибудь')]")
    private WebElement contentField;
    /**
     * определение локатора кнопки "Отправить"
     */
    @FindBy(className = "ComposeControlPanelButton-Button_action")
    private WebElement sendBtn;
    /**
     * определение списка локаторов с темами писем
     */
    @FindBy(xpath = "//*[contains(@class, 'Wrapper js-message-snippet-subject')]/span[1]/span")
    private List<WebElement> subjects;
    /**
     * определение локатора меню пользователя
     */
    @FindBy(xpath = "//div[contains(@class, 'user-pic_has-plus_ user-account__pic')]")
    private WebElement userMenu;
    /**
     * определение локатора кнопки выхода из аккаунта
     */
    @FindBy(xpath = "//*[contains(@aria-label, 'Выйти из аккаунта')]")
    private WebElement logoutBtn;
    /**
     * метод для осуществления нажатия кнопки для входа на страницу авторизации
     */
    public void clickEnterBtn() {
        enterBtn.click();
    }
    /**
     * метод для осуществления нажатия кнопки "Написать"
     */
    public MailPage clickWriteBtn() {
        writeBtn.click();
        return this;
    }
    /**
     * метод для ввода адресата
     */
    public MailPage inputAddressee(String addressee) {
        addresseeField.sendKeys(addressee);
        return this;
    }
    /**
     * метод для ввода темы
     */
    public MailPage inputSubject(String subject) {
        subjectField.sendKeys(subject);
        return this;
    }
    /**
     * метод для ввода содержимого письма
     */
    public MailPage inputContent(String content) {
        contentField.sendKeys(content);
        return this;
    }
    /**
     * метод для осуществления нажатия кнопки "Отправить"
     */
    public MailPage clickSendBtn() {
        sendBtn.click();
        return  this;
    }
    /**
     * метод для получения списка тем
     */
    public List<String> getSubjects() {
        List<String> allSubjects = new ArrayList<>();
        for (WebElement elem:subjects) {
            allSubjects.add(elem.getText());
        }
        return allSubjects;
    }
    /**
     * метод для обновления страницы браузера
     */
    public MailPage refresh(){
        driver.navigate().refresh();
        return this;
    }
    /**
     * метод для нажатия кнопки меню пользователя
     */
    public MailPage entryMenu() {
        userMenu.click();
        return this;
    }
    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public MailPage userLogout() {
        logoutBtn.click();
        return this;
    }
}

